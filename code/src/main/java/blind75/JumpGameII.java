package blind75;

public class JumpGameII {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;  // If there's only one element, no jump is needed.

        int jumps = 0;         // Count of jumps needed to reach the end
        int currentEnd = 0;    // End of the current jump range
        int farthest = 0;      // Farthest point we can reach from the current position

        for (int i = 0; i < n - 1; i++) {
            // Update the farthest point we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump range
            if (i == currentEnd) {
                jumps++;  // We need to jump
                currentEnd = farthest;  // Move to the new farthest point

                // If we can already reach the last index, no need for more jumps
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}

