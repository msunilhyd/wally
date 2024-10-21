package two;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5};
        System.out.println(Arrays.toString(twoSum(7, nums)));
    }
    // Time complexity = O(n)
    // Space complexity = O(n)
    public static int[] twoSum(int target, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
