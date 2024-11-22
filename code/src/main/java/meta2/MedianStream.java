package meta2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianStream {
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue();

    public static void main(String[] args) {
//        int[] arr = {5, 15, 1, 3};
        int[] arr = {5, 1, 3, 15};
        int[] res = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            addNum(arr[i]);
            res[i] = findMedian();
        }
        System.out.println(Arrays.toString(res));
    }

    private static int findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else
            return (maxHeap.peek() + minHeap.peek()) / 2;
    }

    private static void addNum(int n) {
        if (maxHeap.isEmpty() || n <= maxHeap.peek()) {
            maxHeap.offer(n);
        } else
            minHeap.offer(n);

        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
