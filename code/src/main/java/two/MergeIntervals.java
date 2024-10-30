package two;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        for (int[] interval : merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static List<int[]> merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= prev[1]) {
                prev = new int[] { Math.min(curr[0], prev[0]), Math.max(curr[1], prev[1])};
            } else
                prev = curr;
            result.add(prev);
        }
        return result;
    }
}
