package blind75_2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(getSpiral(matrix));
    }

    private static List<Integer> getSpiral(int[][] mat) {
       int top = 0;
       int bottom = mat.length - 1;
       int left = 0;
       int right = mat[0].length - 1;
       List<Integer> list = new ArrayList<>();

       while (list.size() < mat.length * mat[0].length) {
           for (int i=left; i<=right; i++) {
               list.add(mat[top][i]);
           }
           top++;
           for (int i=top; i<=bottom; i++) {
               list.add(mat[i][right]);
           }
           right--;
           for (int i=right; i>=left; i--) {
               list.add(mat[bottom][i]);
           }
           bottom--;
           for (int i=bottom; i>=top; i--) {
               list.add(mat[i][left]);
           }
           left++;
       }

       return list;
    }
}
