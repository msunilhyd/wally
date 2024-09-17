package com.sunil;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        // 1. Edge case
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // 2. Sort the intervals by sort time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 0;

        int end = intervals[0][1];

        // 3. Merge the intervals
        for (int i=1; i<intervals.length; i++) {
            // 3.1 if the start time of current interval is greater than or equal to the end time of the last interval
            if (intervals[i][0] >= end) {
                // 3.1.1 Update the end time of the last interval
                end = intervals[i][1];
            // 3.2 if the start time of the current interval is less than the end time of the last interval
            } else {
                // 3.2.1 Increment the count
                count++;
                // 3.2.2 Update the end time of the last interval
                end = Math.min(end, intervals[i][1]);
            }
        }

        // 4. Return the count
        return count;
    }
}
