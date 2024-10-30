package two;

public class NoOfIslands {

    private static int[][] matrix;
    private static int count = 0;

    public static void main(String[] args) {
        matrix = new int[][] {
                {1, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1}
        };
        find();
        System.out.println(count);
    }

    public static void find() {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    dfs(i, j);
                }
            }
        }
    }

    public static void dfs(int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return;
        if (matrix[i][j] == 1) {
            matrix[i][j] = 0;
            dfs(i+1, j);
            dfs(i-1, j);
            dfs(i, j+1);
            dfs(i, j-1);
        }
    }
}
