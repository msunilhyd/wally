package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

/*
    Given an array of integers nums and an integer target, return indices of the two numbers that they add up to target
 */

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6};
        System.out.println(Arrays.toString(twoSum(nums, 7)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
