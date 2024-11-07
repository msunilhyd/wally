package two;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MeetingRooms2 {

    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {0, 30},
                {5, 10},
                {15, 20}
        };
        System.out.println(find(intervals));
    }

    public static int find(int[][] intervals) {
        if(intervals == null || intervals.length < 1)
            return 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i][0];
        }
        for (int i=0; i<intervals.length; i++) {
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int rooms = 0;
        int end = 0;

        for (int i=0; i<intervals.length; i++) {
            if (starts[i] < ends[end])
                rooms++;
            else
                end++;
        }
        return rooms;
    }
}
