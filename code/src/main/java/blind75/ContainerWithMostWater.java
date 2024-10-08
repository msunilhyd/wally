package blind75;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(findMaxVol(heights));
    }

    public static int findMaxVol(int[] heights) {
        int maxVol = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            maxVol = Math.max(maxVol, (right - left) * Math.min(heights[left], heights[right]));
            System.out.println("maxVol = " + maxVol);
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }
        return maxVol;
    }
}
