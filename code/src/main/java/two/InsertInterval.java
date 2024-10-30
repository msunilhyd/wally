package two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };
        int[] newInterval = {4, 8};
        for (int[] arr : insert(intervals, newInterval)) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<int[]> insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int start = 0;
        int end = 1;

        int i = 0;
        while (i < intervals.length && intervals[i][end] < newInterval[start]) {
            list.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && intervals[i][start] <= newInterval[end]) {
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            i++;
        }
        list.add(newInterval);

        while (i < intervals.length && intervals[i][start] > newInterval[end]) {
            list.add(intervals[i]);
            newInterval = list.getLast();
            i++;
        }

        return list;
    }
}
