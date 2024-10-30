package two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Trie {

    private static TrieNode root = new TrieNode();

    public static void main(String[] args) {
        insert("cars");
//        System.out.println(search("carsd"));
        System.out.println(startWith("cars"));
    }

    public static boolean startWith(String prefix) {
        TrieNode temp = root;
        int i = 0;
        for (char c : prefix.toCharArray()) {
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
                i++;
            } else
                return false;
        }
        return true;
    }

    private static boolean search(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else
                return false;
        }
        if (temp.isEndOfWord)
            return true;
        return false;
    }

    public static void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
        }
        temp.isEndOfWord = true;
    }
}


class TrieNode {
    Map<Character, TrieNode> children;
    public boolean isEndOfWord = false;

    TrieNode() {
        this.children = new HashMap<>();
    }
}