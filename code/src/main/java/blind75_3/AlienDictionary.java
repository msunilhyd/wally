package blind75_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {

    private static StringBuilder res = new StringBuilder();

    private static Map<Character, Set<Character>> adj = new HashMap<>();

    private static Map<Character, String> visitedMap = new HashMap<>();

    private static String[] dict;

    public static void main(String[] args) {

        dict = new String[] {"baa", "abcd", "abca", "cab", "cad"};
        find();
        System.out.println(res.reverse());
    }

    private static void find() {
        buildAdj();
        buildGraph();
        for (char c : adj.keySet()) {
            if (hasCycle(c)) {
                res.append("");
                break;
            }
        }
    }

    private static boolean hasCycle(char c) {
        if (visitedMap.containsKey(c) && visitedMap.get(c).equals("VISITING"))
            return true;
        if (visitedMap.containsKey(c) && visitedMap.get(c).equals("VISITED"))
            return false;

        visitedMap.put(c, "VISITING");
        for (char ch : adj.get(c)) {
           if (hasCycle(ch))
               return true;
        }
        res.append(c);
        visitedMap.put(c, "VISITED");
        return false;
    }

    private static void buildGraph() {
        for (int i=0; i<dict.length - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i+1];
            int len = Math.min(word1.length(), word2.length());
            for (int j=0; j<len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }
    }

    private static void buildAdj() {
        for (String word : dict) {
            for (char c : word.toCharArray()) {
                if (!adj.containsKey(c)) {
                    adj.put(c, new HashSet<>());
                }
            }
        }
    }
}
