package blind75;

public class SearchInRotatedSortedArr {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(find(arr, 3));
    }

    public static int find(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] < nums[right]) {
                if (target > nums[mid] || target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }
}
