package blind75;

public class WordSearch {
    // Time Complexity = O(n3 pow L)
    public static void main(String[] args) {
        String[][] board = {
                {"A", "B", "C", "E"},
                {"S", "F", "C", "S"},
                {"A", "D", "E", "E"}
        };
        System.out.println("SBCRD".substring(0,1));
        System.out.println(find(board, "ABCCED"));
    }

    public static boolean find(String[][] board, String str) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j].equals(str.substring(0, 1)) && dfs(board, str, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(String[][] board, String s, int row, int col, int index) {
        if (index == s.length())
            return true;
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1 || !board[row][col].equals(s.substring(index, index+1)))
            return false;

        board[row][col] = "#";
        if (dfs(board, s, row + 1, col, index + 1) ||
                dfs(board, s, row - 1, col, index + 1) ||
                dfs(board, s, row, col + 1, index + 1) ||
                dfs(board, s, row, col - 1, index + 1)
        ) {
            board[row][col] = s.substring(index, index+1);
            return true;
        }
        board[row][col] = s.substring(index, index+1);
        return false;
    }
}
