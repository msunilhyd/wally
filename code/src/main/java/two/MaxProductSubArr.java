package two;

public class MaxProductSubArr {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println(find(nums));
    }
    public static int find(int[] nums) {
        int prevMin = nums[0];
        int prevMax = nums[0];
        int result = nums[0];

        for (int i=1; i<nums.length; i++) {
            int curMax = Math.max(Math.max(nums[i], nums[i] * prevMax), prevMin * nums[i]);
            int curMin = Math.min(Math.min(nums[i], nums[i] * prevMin), prevMax * nums[i]);

            prevMin = curMin;
            prevMax = curMax;
            result = Math.max(result, curMax);
        }
        return result;
    }
}
