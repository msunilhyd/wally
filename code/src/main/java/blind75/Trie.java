//package blind75;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Trie {
//
//    private TrieNodee root;
//
//    public Trie() {
//        this.root = new TrieNodee('c');
//    }
//
//    public void insert (String word) {
//        if (word == null || word.length() == 0)
//            return;
//
//        TrieNodee parent = root;
//        for (int i=0; i<word.length(); i++) {
//            char cur = word.charAt(i);
//
//            TrieNodee child = parent.children.get(cur);
//            if (child == null) {
//                child = new TrieNodee(false);
//                parent.children.put(cur, child);
//            }
//            parent = child;
//        }
//        parent.isEndOfWord = true;
//    }
//
//    // Returns true if the node is in the trie
//    public boolean search (String word) {
//        if (word == null)
//            return false;
//
//        TrieNodee parent = root;
//        for (int i=0; i<word.length(); i++) {
//            char cur = word.charAt(i);
//            TrieNodee child = parent.children.get(cur);
//            if (child == null)
//                return false;
//            parent = child;
//        }
//        if (parent.isEndOfWord)
//            return true;
//        return false;
//    }
//
//    public boolean startsWithPrefix(String prefix) {
//        TrieNodee parent = root;
//        for (int i=0; i<prefix.length(); i++) {
//            char cur = prefix.charAt(i);
//            TrieNodee child = parent.children.get(cur);
//            if (child == null)
//                return false;
//            parent = child;
//        }
//        return true;
//    }
//
//}
//
//class TrieNode {
//    boolean isEndOfWord;
//    Map<Character, TrieNodee> children;
//
//    TrieNode(boolean isEndOfWord) {
//        this.isEndOfWord = isEndOfWord;
//        this.children = new HashMap<>();
//    }
//}
