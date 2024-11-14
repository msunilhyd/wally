package meta;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MagicalCandyBags {

    public static void main(String[] args) {
        int[] arr = {2, 1, 7, 4, 2};
        int k = 3;
        System.out.println(find(arr, k));
    }
    private static int find(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for (int n : arr) {
            pq.add(n);
        }
        int result = 0;
        for (int i=1; i<=k; i++) {
            int ans = pq.poll();
            result += ans;
            pq.add(ans/2);
        }
        return result;
    }
}
