package two;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        nums = new int[]{3, 2, 1, 0, 4};
        System.out.println(find(nums));
    }

    public static boolean find(int[] nums) {
        int target = nums.length - 1;

        for (int i=nums.length - 1; i>=0; i--) {
            if (nums[i] + i >= target)
                target = i;
        }
        if (target == 0)
            return true;
        return false;
    }
}
