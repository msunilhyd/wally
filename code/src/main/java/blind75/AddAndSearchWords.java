package blind75;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWords {

    private static Map<Character, Map> trie = new HashMap<>();

    public static void main(String[] args) {

        String[] wordsToAdd = {"bad", "dad", "mad"};
        for(String str : wordsToAdd) {
            add(str);
        }
        System.out.println(dfs("b..", trie, 0));
    }

    public static void add(String word) {
        Map<Character, Map> node = trie;
        for (int i=0; i<word.length(); i++) {
            char curr = word.charAt(i);
            if (!node.containsKey(curr))
                node.put(curr, new HashMap());
            node = node.get(curr);
        }
        node.put('*', new HashMap());
    }

    public static boolean dfs(String word, Map<Character, Map> map, int index) {
        if (index == word.length()) {
            if (map.get('*') != null)
                return true;
            else
                return false;
        }

        char curr = word.charAt(index);
        if (curr == '.') {
            for (char c : map.keySet()) {
               if (dfs(word, map.get(c), index + 1))
                   return true;
            }
        } else {
            if (map.get(curr) != null) {
                return dfs(word, map.get(curr), index + 1);
            } else
                return false;
        }
        return false;
    }
}
