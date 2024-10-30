package two;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i=1; i<nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
