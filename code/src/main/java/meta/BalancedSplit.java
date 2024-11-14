package meta;

import java.util.Arrays;

public class BalancedSplit {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 1};
        System.out.println(find(arr));
    }

    private static boolean find(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int left = 1;
        int right = arr.length - 1;
        int lsum = arr[0];
        int rsum = arr[right];

        while (left < right) {
            while (left < right && lsum < rsum) {
                lsum += arr[left];
                left++;
            }
            while (left < right && lsum > rsum) {
                right--;
                rsum += arr[right];
            }
            if (lsum == rsum)
                return left == right;
        }
        return lsum == rsum && arr[left] != arr[right];
    }
}
