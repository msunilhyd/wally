package com.sunil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // 1. Edge case
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // 2. Sort the intervals by sort time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int[] prev = intervals[0];

        // 3. Merge the intervals
        for (int i=1; i<intervals.length; i++) {
            // 3.1. If the current interval overlaps with the previous one, merge them
            if (intervals[i][0] > prev[1]) {
                // 3.1.1 Add the previous interval to the result
                result.add(prev);
                // 3.1.2 Update the previous interval
                prev = intervals[i];
            // 3.2 If the current interval doesn't overlap with the previous one, merge them
            } else {
                // 3.2.1 Update the previous interval
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        // 4. Add the last interval to the result
        // 5. Convert the result to an array
        return result.toArray(new int[result.size()][]);
    }
}
