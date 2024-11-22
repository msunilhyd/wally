package meta;

import java.util.*;
import java.util.stream.IntStream;

public class MinimizingPermutations {

//    Time Complexity = O(n! * n^3)
    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        System.out.println(find(arr));
    }

    private static int find(int[] arr) {
        int ret = 0;
        int[] target = IntStream.rangeClosed(1, arr.length).toArray();
        Set<String> seen = new HashSet();
        Queue<int[]> queue = new LinkedList();
        queue.offer(arr);
        seen.add(Arrays.toString(arr));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] curr = queue.poll();
                if (Arrays.equals(curr, target))
                    return ret;
                for (int j=0; j<curr.length; j++) {
                    for (int k=j+1; k<curr.length; k++) {
                        int[] next = curr.clone();
                        reverse(next, j, k);
                        if (!seen.contains(Arrays.toString(next))) {
                            seen.add(Arrays.toString(next));
                            queue.offer(next);
                        }
                    }
                }
            }
            ret++;
        }
        return ret;
    }

    private static void reverse(int[] arr, int from, int to) {
        for (; from < to; from++, to--) {
            int temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
        }
    }
}
