package two;

import java.util.*;

public class SpiralMatrix {

    private static int[][] matrix;

    public static void main(String[] args) {
        matrix = new int[][] {
                {1, 2, 3, 11},
                {4, 5, 6, 12},
                {7, 8, 9, 13}
        };
        getSpiral();
    }

    public static void getSpiral() {
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int noOfElements = (right + 1) * (bottom + 1);

        List<Integer> list = new ArrayList<>();

        while (list.size() < noOfElements) {
            int i = left;
            while (i <= right && list.size() < noOfElements) {
                list.add(matrix[top][i]);
                i++;
            }
            top++;
            i = top;
            while (i <= bottom && list.size() < noOfElements) {
                list.add(matrix[i][right]);
                i++;
            }
            right--;
            i = right;
            while (i >= left && list.size() < noOfElements) {
                list.add(matrix[bottom][i]);
                i--;
            }
            bottom--;
            i = bottom;
            while (i >= top && list.size() < noOfElements) {
                list.add(matrix[i][left]);
                i--;
            }
            left++;
        }
        System.out.println(list);
    }
}
