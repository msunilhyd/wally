package two;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(find(nums));
    }

    public static int[] find(int[] nums) {
        int[] temp = new int[nums.length];
        int pre = 1;
        for (int i=0; i<nums.length; i++) {
            temp[i] = pre;
            pre = pre * nums[i];
        }

        int post = 1;
        for (int i=nums.length - 1; i>=0; i--) {
           temp[i] = temp[i] * post;
           post = post * nums[i];
        }

        System.out.println(Arrays.toString(temp));
        return temp;
    }
}
