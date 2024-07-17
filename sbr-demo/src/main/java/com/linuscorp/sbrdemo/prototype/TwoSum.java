package com.linuscorp.sbrdemo.prototype;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 7};
        System.out.println(Arrays.toString(twoSum(nums, 8)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            int diff = target - num;
            if (map.containsKey(diff)) {
                return new int[]{diff, num};
            } else {
                map.put(num, 0);
            }
        }
//       return new int[]{};
       return null;
    }
}
