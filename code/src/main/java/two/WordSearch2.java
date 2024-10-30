package two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSearch2 {

    private static char[][] board;
    private static TrieNodeImpl root = new TrieNodeImpl();
    private static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        board = new char[][] {
                {'o', 'a', 'n', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = new String[] {"oath", "pea", "eat", "rain"};
        find(words);
        System.out.println(result);
        System.out.println(exists("oath"));
        System.out.println(root.children);
    }

    public static void find(String[] words) {
        for (String word : words) {
            insert(word);
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (root.children.containsKey(board[i][j]))
                    dfs(i, j, root);
            }
        }
    }

    public static void dfs(int i, int j, TrieNodeImpl node) {
        if (node == null)
            return;
        if (node.isWord) {
            result.add(node.word);
            node.isWord = false;
            return;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || !node.children.containsKey(board[i][j]))
            return;

        char temp = board[i][j];
        board[i][j] = '#';

        dfs(i+1, j, node.children.get(temp));
        dfs(i-1, j, node.children.get(temp));
        dfs(i, j+1, node.children.get(temp));
        dfs(i, j-1, node.children.get(temp));

        board[i][j] = temp;
    }

    public static boolean exists(String word) {
        TrieNodeImpl node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }
        return node.isWord;
    }

    private static void insert(String word) {
        TrieNodeImpl node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNodeImpl());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
        node.word = word;
    }
}

class TrieNodeImpl {
    Map<Character, TrieNodeImpl> children;
    boolean isWord;
    String word;

    public TrieNodeImpl() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}
