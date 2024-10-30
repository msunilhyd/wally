package two;

public class HouseRobber2 {

    private static int[] nums;

    public static void main(String[] args) {
        nums = new int[]{1, 2, 3, 1};
//        nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(find());
    }

    private static int find() {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2) {
            return Math.max(nums[1], nums[2]);
        }

        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length];

        recurse(dp1, 0, nums.length - 2);
        recurse(dp2, 1, nums.length - 1);

        return Math.max(dp1[nums.length - 2], dp2[nums.length - 1]);
    }

    private static void recurse(int[] dp, int start, int end) {
        dp[start] = nums[start];
        dp[start + 1] = Math.max(dp[start], nums[start+1] );
        for (int i=start+2 ; i<=end; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }
    }
}
