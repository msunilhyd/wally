package two;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {2, 3},
                {4, 5},
                {1, 2}
        };
        System.out.println(find(intervals));
    }

    private static int find(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int[] prev = intervals[0];
        int count = 0;
        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < prev[1])
                count++;
            else
                prev = curr;
        }
        return count;
    }
}
