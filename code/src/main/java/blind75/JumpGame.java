package blind75;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canReach(nums));
    }

    public static boolean canReach(int[] nums) {
        int target = nums.length - 1;
        for (int i=nums.length-1; i>=0; i--) {
            if (i + nums[i] >= target)
                target = i;
        }
        return target == 0;
    }
}
