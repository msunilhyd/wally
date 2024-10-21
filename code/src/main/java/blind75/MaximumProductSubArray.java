package blind75;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int prevMax = nums[0];
        int prevMin = nums[0];
        int result = nums[0];

        for (int i=1; i<nums.length; i++) {
            int curMax = Math.max(nums[i], Math.max(nums[i] * prevMax, nums[i] * prevMin));
            int curMin = Math.min(nums[i], Math.min(nums[i] * prevMax, nums[i] * prevMin));

            result = Math.max(result, curMax);
            prevMax = curMax;
            prevMin = curMin;
        }
        return result;
    }
}
