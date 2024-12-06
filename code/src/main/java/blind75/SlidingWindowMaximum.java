package blind75;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] nums = {2, 1, 78, 90, 57, 89, 56 };
        System.out.println(Arrays.toString(maximumSlidingWindow(nums, 3)));
    }

    public static int[] maximumSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList();

        int l = 0;
        int r = 0;

        while (r < nums.length) {

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[r])
                deque.pollLast();
            deque.addLast(r);

            while (!deque.isEmpty() && r - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
            // whenever we add to the result, our left pointer shifts l++
            if (r + 1 >= k) {
                result[r-k+1] = nums[deque.peekFirst()];
                l++;
            }
            r++;
        }

        return result;
    }
}
