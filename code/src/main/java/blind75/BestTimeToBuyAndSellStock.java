package blind75;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] nums) {
        int maxProfit = 0;
        int min = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (min > nums[i])
                min = nums[i];
            maxProfit = Math.max(maxProfit, nums[i] - min);
        }
        return maxProfit;
    }
}
