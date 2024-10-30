package two;

public class MinimumInRotatedSortedArr {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 2, 3};
        System.out.println(find(nums));
    }

    public static int find(int nums[]) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[right] > nums[mid]) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return nums[left + 1];
    }
}
