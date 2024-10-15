package blind75;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlapIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1, 2}, {2, 3}, {3, 4}
        };
        System.out.println(find(intervals));
    }

    public static int find(int[][] intervals) {
        int count = 0;
        int prev = 0;

        int start = 0;
        int end = 1;

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            int[] previous = intervals[prev];
            if (curr[start] < previous[end])
                count++;
            else
                prev = i;
        }
        return count;
    }
}
