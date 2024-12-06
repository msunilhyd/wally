package blind75_2;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(Arrays.toString(find(arr)));
    }

    private static int[] find(int[] arr) {
        int[] res = new int[arr.length];
        int cur = 1;
        for (int i=0; i<arr.length; i++) {
            res[i] = cur;
            cur = cur * arr[i];
        }
        cur = 1;
        for (int i=arr.length-1; i>=0; i--) {
            res[i] = res[i] * cur;
            cur = cur * arr[i];
        }
        return res;
    }
}
