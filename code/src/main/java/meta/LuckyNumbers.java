package meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,10,4,2},
                {9,3,8,7},
                {15,16,17,12}
        };
        System.out.println(luckyNumbers(matrix));
    }

    public static List<Integer> luckyNumbers(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[] minInRows = new int[m];
        int[] maxInCols = new int[n];

        Arrays.fill(minInRows, Integer.MAX_VALUE);

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                minInRows[i] = Math.min(minInRows[i], matrix[i][j]);
                maxInCols[j] = Math.max(maxInCols[j], matrix[i][j]);
            }
        }

        List<Integer> luckyNumbers = new ArrayList();

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (minInRows[i] == maxInCols[j]) {
                    luckyNumbers.add(minInRows[i]);
                }
            }
        }
        return luckyNumbers;
    }
}
