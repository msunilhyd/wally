package org.example;

public class BestTimeToBuySellStock {

    public static void main(String[] args) {
        int[] nums = {0, 2, 4, 1, 5, 3, 9};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int maxProfit = 0;
        int minUntilNow = nums[0];

        for (int i=0; i<nums.length; i++) {
            minUntilNow = Math.min(minUntilNow, nums[i]);
            maxProfit = Math.max(maxProfit, nums[i] - minUntilNow);
        }

        return maxProfit;
    }
}
