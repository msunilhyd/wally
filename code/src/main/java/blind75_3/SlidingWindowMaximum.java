package blind75_3;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(find(arr, 3)));
    }

    private static int[] find(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];
        int n = arr.length;
        int left = 0;
        int right = 0;

        Deque<Integer> deque = new LinkedList();

        while (right < arr.length) {
            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[right]) {
                deque.pollLast();
            }
            deque.addLast(right);
            while (!deque.isEmpty() && right - deque.peekFirst() + 1 > k) {
                deque.pollFirst();
            }
            if (right + 1 >= k) {
                res[right - k + 1] = arr[deque.peekFirst()];
                left++;
            }
            right++;
        }
        return res;
    }
}
