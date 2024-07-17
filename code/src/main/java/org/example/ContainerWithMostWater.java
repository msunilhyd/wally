package org.example;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 1, 9, 2};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int max = 0;
        while (left < right) {
            int area = (right - left) * (Math.min(nums[left], nums[right]));
            max = Math.max(max, area);
            if (nums[left] <= nums[right])
                left += 1;
            else
                right -= 1;
        }
        return max;
    }
}
