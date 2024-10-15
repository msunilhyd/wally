package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] list = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] arr : merge(list)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<int[]> merge(int[][] intervals) {
        int start = 0;
        int end = 1;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> list = new ArrayList();
        list.add(intervals[0]);

        int[] prev = intervals[0];

        for (int[] cur : intervals) {
            if (cur[start] <= prev[end]) {
                prev[end] = Math.max(prev[end], cur[end]);
            } else {
                list.add(cur);
                prev = cur;
            }
        }

        return list;
    }
}
