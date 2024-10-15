package blind75;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {

        for (int i=0; i<matrix.length; i++) {
            for (int j=i; j<matrix.length; j++) {
                System.out.println("i = " + i + ", j = " + j);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("======");

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
