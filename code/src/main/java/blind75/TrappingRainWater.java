package blind75;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height1));
    }

    private static int trap(int[] heights) {
        // If there are less than 3 bars, no water can be trapped
        if (heights == null || heights.length < 3)
            return 0;

        int left = 0;
        int right = heights.length - 1;

        int leftMax = heights[left];
        int rightMax = heights[right];
        int waterTrapped = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {
                if (heights[left] >= leftMax) {
                    leftMax = heights[left]; // Update leftMax if current height is greater
                } else {
                    waterTrapped += leftMax - heights[left];
                }
                left++; // Move the left pointer to the right
            } else {
                if (heights[right] >= rightMax) {
                    rightMax = heights[right]; // Update the rightMax if current height is greater
                } else {
                    waterTrapped += rightMax - heights[right]; // Water is trapped
                }
                right--;
            }
        }
        return waterTrapped;
    }
}
