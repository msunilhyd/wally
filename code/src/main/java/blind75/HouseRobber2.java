package blind75;

import java.util.Arrays;

public class HouseRobber2 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];

        rob(dp1, 0, nums.length - 2, nums);
        rob(dp2, 1, nums.length - 1, nums);

        System.out.println(Arrays.toString(dp1));
        System.out.println(Arrays.toString(dp2));

        return Math.max(dp1[nums.length - 2], dp1[nums.length - 1]);
    }

    public static void rob(int[] dp, int start, int end, int[] nums) {
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);

        for (int i=start+2; i<=end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
    }
}
