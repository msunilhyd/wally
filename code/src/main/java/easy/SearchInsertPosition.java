package easy;

// 7
public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 9, 10};
        System.out.println(searchInsertPos(nums, 8));
    }
    public static int searchInsertPos(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        // 1, 2, 4, 7, 9

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else right = mid - 1;
        }
        if (nums[left-1] == target)
            return left-1;
        else return left;
    }
}
