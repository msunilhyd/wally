package two;

public class HouseRobber {

    private static int[] nums;

    public static void main(String[] args) {
        nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(find());
    }

    public static int find() {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int max = 0;
        for (int i=2; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
