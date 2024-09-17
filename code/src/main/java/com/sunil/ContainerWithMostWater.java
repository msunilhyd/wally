package com.sunil;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int max = 0, left = 0, right = heights.length - 1, area;
        while (left < right) {
            if (heights[right] < heights[left]) {
                area = (right - left) * (heights[right]);
                right--;
            } else {
                area = (right - left) * (heights[left]);
                left++;
            }
            max = Math.max(max, area);
        }
        return max;
    }
}
