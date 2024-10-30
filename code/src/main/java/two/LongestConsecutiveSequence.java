package two;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        Integer[] nums = {100, 4, 200, 1, 2, 3, 5, 6, 101, 102, 103, 104, 105, 106, 107};
        System.out.println(find(nums));
    }

    public static int find(Integer[] nums) {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(nums));
        int maxCount = 0;
        for (int i=0; i<nums.length; i++) {
            int target = nums[i];
            int curCount = 1;
            while (set.contains(target + 1)){
                curCount++;
                maxCount = Math.max(maxCount, curCount);
                target++;
            }
        }
        return maxCount;
    }
}
