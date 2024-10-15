package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        matrix = matrixZeroes(matrix);
        for (int[] arr : matrix) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static int[][] matrixZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0)
                    list.add(new int[] {i, j});
            }
        }

        for (int[] arr : list) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][arr[1]] = 0;
            }
            for (int j=0; j<matrix[0].length; j++) {
                matrix[arr[0]][j] = 0;
            }
        }

        return matrix;
    }
}
