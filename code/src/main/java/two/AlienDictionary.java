package two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {

    private static Map<Character, Set<Character>> adj = new HashMap<>();

    private static Map<Character, String> visitMap = new HashMap<>();

    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        find(dict);
        System.out.println(result.reverse());
    }

    public static void find(String[] dict) {
        buildAdj(dict);
        buildGraph(dict);

        for (char c : adj.keySet()) {
            if (!visitMap.containsKey(c) && hasCycle(c)) {
                result.append("");
                return;
            }
        }
    }

    public static void buildGraph(String[] dict) {
        for (int i=0; i<dict.length - 1; i++) {
            String first = dict[i];
            String second = dict[i+1];

            int length = Math.min(first.length(), second.length());
            for (int j=0; j<length; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    adj.get(first.charAt(j)).add(second.charAt(j));
                    break;
                }
            }
        }
    }

    public static void buildAdj(String[] dict) {
        for (String word : dict) {
            for (char c : word.toCharArray()) {
                if (!adj.containsKey(c))
                    adj.put(c, new HashSet<>());
            }
        }
    }

    public static boolean hasCycle(char c) {
        if (visitMap.containsKey(c) && visitMap.get(c).equals("VISITING"))
            return true;
        else if (visitMap.containsKey(c) && visitMap.get(c).equals("VISITED"))
            return false;

        visitMap.put(c, "VISITING");

        for (char neighbor : adj.get(c)) {
            if (hasCycle(neighbor))
                return true;
        }

        visitMap.put(c, "VISITED");
        result.append(c);

        return false;
    }
}
