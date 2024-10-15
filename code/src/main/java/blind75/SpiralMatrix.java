package blind75;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(getSpiral(arr));
    }

    public static List<Integer> getSpiral(int[][] matrix) {

        int top = 0;
        int left = 0;

        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        int totalElements = (right + 1) * (bottom+ 1);
        List<Integer> ansList = new ArrayList<>();

        while (ansList.size() < totalElements) {

            for (int i=left; i<=right && ansList.size() < totalElements ; i++) {
                ansList.add(matrix[top][i]);
            }
            top++;
            for (int i=top; i<=bottom && ansList.size() < totalElements; i++) {
                ansList.add(matrix[i][right]);
            }
            right--;
            for (int i=right; i>=left && ansList.size() < totalElements; i--) {
                ansList.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i=bottom; i>=top && ansList.size() < totalElements; i--) {
                ansList.add(matrix[i][left]);
            }
            left++;
        }
        return ansList;
    }
}
