package com.sunil;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSeld(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];

        ans[0] = 1;

        for (int i=0; i<len; i++)
            ans[i] = ans[i-1]*nums[i-1];

        int right = 1;
        for (int i=len-1; i>-1; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
}
