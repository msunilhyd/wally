package blind75_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary2 {

    private static StringBuilder res = new StringBuilder();

    private static Map<Character, Set<Character>> adj = new HashMap();

    private static Map<Character, String> visitedMap = new HashMap<>();

    public static void main(String[] args) {
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(find(dict));
    }

    public static String find(String[] dict) {
        buildAdj(dict);
        buildGraph(dict);
        for (char c : adj.keySet()) {
            if (hasCycle(c))
                return "";
        }
        return res.reverse().toString();
    }

    private static boolean hasCycle(char curr) {
        if (visitedMap.get(curr) != null && visitedMap.get(curr).equals("VISITING"))
            return true;
        if (visitedMap.get(curr) != null && visitedMap.get(curr).equals("VISITED"))
            return false;
        visitedMap.put(curr, "VISITING");
        for (char c : adj.get(curr)) {
           if (hasCycle(c))
               return true;
        }
        visitedMap.put(curr, "VISITED");
        res.append(curr);
        return false;
    }

    private static void buildGraph(String[] dict) {
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

    private static void buildAdj(String[] dict) {
        for (String word : dict) {
            for (char c : word.toCharArray()) {
                if (!adj.containsKey(c))
                    adj.put(c, new HashSet());
            }
        }
    }
}
