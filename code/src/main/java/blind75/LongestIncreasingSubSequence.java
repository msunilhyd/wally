package blind75;

public class LongestIncreasingSubSequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for (int i=0; i<nums.length; i++) {
            dp[i] = 1;
        }
        for (int i=1; i<nums.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }
}
