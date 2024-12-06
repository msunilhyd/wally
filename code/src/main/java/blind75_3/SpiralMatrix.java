package blind75_3;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(find(mat));
    }

    private static List<Integer> find(int[][] mat) {
        int left = 0;
        int right = mat[0].length - 1;
        int top = 0;
        int bottom = mat.length - 1;
        List<Integer> res = new ArrayList<>();

        while (res.size() < mat.length * mat[0].length) {
            for (int i=left; i<=right; i++) {
                res.add(mat[top][i]);
            }
            top++;
            for (int i=top; i<=bottom; i++) {
                res.add(mat[i][right]);
            }
            right--;
            for (int i=right; i>=left; i--) {
                res.add(mat[bottom][i]);
            }
            bottom--;
            for (int i=bottom; i>=top; i--) {
                res.add(mat[i][left]);
            }
            left++;
        }
        return res;
    }
}
