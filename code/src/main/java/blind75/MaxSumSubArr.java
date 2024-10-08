package blind75;

public class MaxSumSubArr {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSum(nums));
    }

    public static int findMaxSum(int[] nums) {
        int curMax = nums[0];
        int max = nums[0];

        for (int i=1; i<nums.length; i++) {
            curMax = Math.max(nums[i], nums[i] + curMax);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
