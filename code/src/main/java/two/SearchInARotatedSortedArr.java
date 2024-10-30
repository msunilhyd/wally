package two;

public class SearchInARotatedSortedArr {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(find(nums, 4));
    }

    public static int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[right] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (target < nums[mid] && target >= nums[left])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
