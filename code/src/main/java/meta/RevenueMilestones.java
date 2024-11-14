package meta;

import java.util.Arrays;

public class RevenueMilestones {

    public static void main(String[] args) {
        int[] revenues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] milestones = {100, 200, 500};

        System.out.println(Arrays.toString(find(revenues, milestones)));
    }

    private static int[] find(int[] revenues, int[] milestones) {
        int[] sum = new int[revenues.length];
        sum[0] = revenues[0];
        for (int i=1; i<revenues.length; i++) {
            sum[i] = sum[i-1] + revenues[i];
        }
        int[] result = new int[milestones.length];
        for (int i=0; i<result.length; i++) {
            result[i] = 1+binarySearch(sum, milestones[i]);
        }
        return result;
    }

    private static int binarySearch(int[] sum, int n) {
        int left = 0;
        int right = sum.length - 1;

        while (left < right) {
            int mid = left + (right - left)/2;
            if (n == sum[mid])
                return mid;
            else if (n < sum[mid]) {
                right = mid-1;
            } else
                left = mid+1;
        }
        return left;
    }
}
