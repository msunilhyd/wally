package blind75;
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for easier binary search
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0, right = m;

        while (left <= right) {
            int partition1 = (left + right) / 2;  // Partition in nums1
            int partition2 = (m + n + 1) / 2 - partition1;  // Partition in nums2

            // Edge cases when partitions are at the edges of the arrays
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if we have found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // We have found the correct partition
                if ((m + n) % 2 == 0) {
                    // If even length, median is the average of two middle elements
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // If odd length, median is the max of the left partition
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move the partition in nums1 to the left
                right = partition1 - 1;
            } else {
                // Move the partition in nums1 to the right
                left = partition1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        int[] nums1 = {1, 3};
        int[] nums2 = {2};

        System.out.println("Median: " + solution.findMedianSortedArrays(nums1, nums2));  // Output: 2.0

        int[] nums1b = {1, 2};
        int[] nums2b = {3, 4};

        System.out.println("Median: " + solution.findMedianSortedArrays(nums1b, nums2b));  // Output: 2.5
    }
}
