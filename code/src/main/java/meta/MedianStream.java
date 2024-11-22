package meta;

import java.util.*;

public class MedianStream {

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) {
        int[] arr = {5, 15, 1, 3};
        System.out.println(Arrays.toString(find(arr)));
    }

    private static void addNum(int n) {
        if (maxHeap.isEmpty() || n <= maxHeap.peek()) {
            maxHeap.offer(n);
        } else {
            minHeap.offer(n);
        }
        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private static int findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else
            return (maxHeap.peek() + minHeap.peek()) / 2;
    }

    private static int[] find(int[] arr) {
        int[] res = new int[arr.length];
        int i = 0;
        for (int n : arr) {
            addNum(n);
            res[i] = findMedian();
            i++;
        }
        return res;
    }
}
