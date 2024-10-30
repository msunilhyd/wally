package two;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(find(heights));
    }
    // Time Complexity = O(n)
    // Space Complexity = O(1)
    public static int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        int maxVol = 0;

        while (left < right) {
            int curVol = (right - left) * Math.min(nums[right], nums[left]);
            maxVol = Math.max(maxVol, curVol);
            if (left < right)
                left++;
            else
                right--;
        }
        return maxVol;
    }
}
