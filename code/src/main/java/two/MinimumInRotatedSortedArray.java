package two;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[left])
                right = mid;
            else
                left = mid;
        }
        return nums[left+1];
    }
}
