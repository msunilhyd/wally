package meta;

import java.util.*;
public class MinimizingPermutations {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        Map<Integer, Integer> updatedIndexes = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i=0; i<arr.length; i++) {
            heap.add(arr[i]);
            updatedIndexes.put(arr[i], i);
        }
        int curr = 0;
        int swapCount = 0;
        while (!heap.isEmpty()) {
            int n = heap.poll();
            if (n < arr[curr]) {
                reverse(arr, Math.min(updatedIndexes.get(n), curr), Math.max(updatedIndexes.get(n), curr), updatedIndexes);
                swapCount++;
            }
            curr++;
        }

        return swapCount;
    }

    private static void reverse(int[] arr, int min, int max, Map<Integer, Integer> updatedIndexes) {
        for (int i=min, j=max; i<=max && j>i; i++, j--) {
            swap(arr, i, j);
            updatedIndexes.put(arr[i], i);
            updatedIndexes.put(arr[j], j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
