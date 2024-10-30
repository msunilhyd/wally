package two;

public class WordSearch {

    private static Character[][] board;
    private static String word;

    public static void main(String[] args) {
        board = new Character[][] {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        word = "ABCCEF";
        System.out.println(doesExist());
    }

    public static boolean doesExist() {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0))
                    return dfs(i, j, 0);
            }
        }
        return false;
    }

    public static boolean dfs(int i, int j, int index) {
        if (index == word.length())
            return true;

        if (i >= board.length || i < 0 || j > board[0].length || j < 0 || board[i][j] != word.charAt(index))
            return false;
//        board[i][j] = '#';
        if (dfs(i+1, j, index+1) || dfs(i, j+1, index+1) || dfs(i, j-1, index+1) || dfs(i-1, j, index+1))
            return true;
//        board[i][j] = word.charAt(index);
        return false;
    }
}
