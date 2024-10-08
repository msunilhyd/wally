package blind75;

import java.util.Arrays;

public class ProductOfArrExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productOfArrExSelf(nums)));
    }

    public static int[] productOfArrExSelf(int[] nums) {
        int[] res = new int[nums.length];

        int start1 = 1;
        for (int i=0; i<nums.length; i++) {
            res[i] = start1;
            start1 = start1 * nums[i];
        }
//        res = [1, 1, 2, 6]
        int start2 = 1;
        for (int i=nums.length-1; i>=0; i--) {
            res[i] = res[i] * start2;
            start2 = start2 * nums[i];
        }
        return res;
    }
}
