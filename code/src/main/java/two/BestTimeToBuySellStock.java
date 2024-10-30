package two;

public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] nums = {4, 3, 7, 1, 8, 9};
        System.out.println(find(nums));
    }
    // Time Complexity = O(n)
    // Space Complexity = O(1)
    public static int find(int[] nums) {
        int maxProfit = 0;
        int min = nums[0];

        for (int i=1; i<nums.length; i++) {
            min = Math.min(min, nums[i]);
            maxProfit = Math.max(maxProfit, nums[i] - min);
        }
        return maxProfit;
    }
}
