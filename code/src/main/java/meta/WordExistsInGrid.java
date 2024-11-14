package meta;

public class WordExistsInGrid {

    private static char[][] mat;

    public static void main(String[] args) {
        mat = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exists("ABCCEKD"));
    }

    private static boolean exists(String word) {
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[0].length; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if(dfs(i, j, word, 0))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int i, int j, String word, int index) {
        if (index == word.length() - 1)
            return true;

        if (!isValid(i, j))
            return false;
        if (mat[i][j] == word.charAt(index))
            return dfs(i, j-1, word, index+1) || dfs(i-1, j, word, index+1) || dfs(i+1, j, word, index+1) || dfs(i, j+1, word, index+1);
        return false;
    }

    private static boolean isValid(int i, int j) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length)
            return false;
        return true;
    }
}
