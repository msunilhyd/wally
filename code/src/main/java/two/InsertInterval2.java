package two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval2 {

    private static List<int[]> result = new ArrayList<>();

    public static void main(String[] args) {
        int[][] intervals = new int[][]{
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] interval = {4, 8};
        insert(intervals, interval);
        for(int[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void insert(int[][] intervals, int[] newInterval) {
        int i=0;
        int start = 0;
        int end = 1;
        while (i < intervals.length && intervals[i][end] < newInterval[start]){
            result.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][start] <= newInterval[end]) {
            newInterval = new int[]{Math.min(intervals[i][start], newInterval[start]), Math.max(intervals[i][end], newInterval[end])};
            i++;
        }
        result.add(newInterval);

        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
    }
}
