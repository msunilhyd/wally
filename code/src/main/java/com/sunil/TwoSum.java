package com.sunil;

import java.util.HashMap;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int targetNum = target - nums[i];
            if (map.containsKey(targetNum)) {
                return new int[] {map.get(targetNum), i};
            } else
                map.put(nums[i], i);
        }
        return null;
    }
}
