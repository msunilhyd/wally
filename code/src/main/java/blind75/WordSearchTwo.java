package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchTwo {

    private static char [][] board;

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        String[] arr = new String[]{"sunil", "kumar", "oath", "pea", "eat", "rain"};
//        String[] arr = new String[]{"eat"};
        list.addAll(Arrays.asList(arr));

        board = new char[][]{
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        List<String> ansList = find(list, board);
        System.out.println("ansList = " + ansList);
    }

    public static List<String> find(List<String> wordList, char[][] board) {
        List<String> ansList = new ArrayList();
        System.out.println(wordList);
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                for (String word : wordList) {
//                    System.out.println("calling for " + word);
                    if (board[i][j] == word.charAt(0) ) {
                        boolean ans = dfs(i, j, 0, word);
                        System.out.println("for word = " + word + " dfs = " + ans);
                        if (ans) {
                            ansList.add(word);
                            break;
                        }
                    }
                }
            }
        }
//        System.out.println(ansList);
        return ansList;
    }

    public static boolean dfs(int row, int col, int index, String word) {
        if (index > word.length() - 1)
            return true;
//        System.out.println("word = " + word);
        if (row < 0 || row > board.length-1 || col < 0 || col > board[0].length-1 || board[row][col] != word.charAt(index))
            return false;
        board[row][col] = '#';
        if (
                dfs(row + 1, col, index + 1, word) ||
                        dfs (row - 1, col, index + 1, word) ||
                        dfs (row, col + 1, index + 1, word) ||
                        dfs(row, col - 1, index + 1, word)
        ) {
//            board[row][col] = word.charAt(index);
            return true;
        }
        board[row][col] = word.charAt(index);
        return false;
    }
}
