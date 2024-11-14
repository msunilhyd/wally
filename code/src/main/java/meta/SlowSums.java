package meta;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlowSums {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : arr) {
            pq.add(n);
        }
        int res = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            res += a + b;
            pq.add(a + b);
        }
        return res;
    }
}
