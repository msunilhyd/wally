package blind75_3;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWords {

    private static Map<Character, Map> trie = new HashMap<>();

    public static void main(String[] args) {
        String[] words = {"bat", "bad", "cool", "book"};
        for (String word : words)
            addWord(word, trie);
        System.out.println(search("bowok", trie, 0));
    }

    private static boolean search(String str, Map<Character, Map> map, int index) {
        if (map == null)
            return false;
        if (index == str.length()) {
            if (map.get('*') != null) {
                return true;
            }
            else
                return false;
        }
        char curr = str.charAt(index);
        if (curr == '.') {
            for (char c : map.keySet()) {
                if (search(str, map.get(c), index + 1))
                    return true;
            }
        } else {
            if (search(str, map.get(curr), index + 1))
                return true;
        }
        return false;
    }

    private static void addWord(String str, Map<Character, Map> map) {
        Map<Character, Map> node = map;
        for (char c : str.toCharArray()) {
            if (!node.containsKey(c))
                node.put(c, new HashMap());
            node = node.get(c);
        }
        node.put('*', new HashMap());
    }
}
