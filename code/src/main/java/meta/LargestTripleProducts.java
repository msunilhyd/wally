package meta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestTripleProducts {
// Time Complexity = O(n)
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(find(arr)));
    }

    private static int[] find(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, Comparator.reverseOrder());
        int[] result = new int[arr.length];
        result[0] = -1;
        result[1] = -1;

        pq.add(arr[0]);
        pq.add(arr[1]);

        for (int i=2; i<arr.length; i++) {
            pq.add(arr[i]);
            int first = pq.poll();
            int second = pq.poll();
            int third = pq.poll();
            result[i] = first * second * third;
            pq.add(first);
            pq.add(second);
            pq.add(third);
        }
        return result;
    }
}
