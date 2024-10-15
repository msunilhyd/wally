package blind75;

import java.lang.reflect.ParameterizedType;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 1, 2, 2, -1, -4, 4, 4};
        for (List<Integer> ans : threeSum(nums)) {
            System.out.println(ans);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        if (nums.length == 0)
            return resList;

        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int cur = nums[i];

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = cur + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(cur);
                    ans.add(nums[left]);
                    ans.add(nums[right]);
                    resList.add(ans);
                    while (nums[left] == nums[left+1])
                        left++;
                    while (nums[right] == nums[right - 1])
                        right--;
                    left++;
                    right--;
                } else if (sum > 0)
                    right--;
                else
                    left++;
            }
        }

        return resList;
    }

}
