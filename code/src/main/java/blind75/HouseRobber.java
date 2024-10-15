package blind75;

public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(findMaxProfit(nums));
    }

    public static int findMaxProfit(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
