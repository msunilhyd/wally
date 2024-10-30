package two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        for(int[] arr : find(nums)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<int[]> find(int[] nums) {
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        for (int i=0; i<nums.length - 2; i++) {
            int curr = nums[i];
            if (i > 0 && curr == nums[i-1])
                continue;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (curr + nums[left] + nums[right] == 0) {
                    res.add(new int[]{curr, nums[left], nums[right]});
                } else if (curr + nums[left] + nums[right] < 0) {
                    while (left + 1 < nums.length && nums[left] != nums[left + 1])
                        left++;
                } else {
                    while (right - 1 >=0 && nums[right] != nums[right - 1])
                        right--;
                }
                left++;
                right--;
            }
        }
        return res;
    }
}
