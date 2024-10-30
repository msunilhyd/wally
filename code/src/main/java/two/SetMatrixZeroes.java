package two;

import blind75.PacificAtlantic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

    private static int[][] matrix;

    public static void main(String[] args) {
        matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes();
        for(int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void setZeroes() {
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    list.add(new int[]{i, j});
            }
        }
        for (int[] arr : list) {
            int row = arr[0];
            int col = arr[1];

            for (int i=0; i< matrix.length; i++) {
                matrix[i][col] = 0;
            }

            for (int j=0; j<matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
    }
}
