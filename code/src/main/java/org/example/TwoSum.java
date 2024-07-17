package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 4, 7, 8};
        System.out.println(Arrays.toString(find(nums, 9)));
    }

    public static int[] find(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{diff, nums[i]};
            } else
                map.put(nums[i], i);
        }
        return null;
    }
}
