package blind75;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 30}, {5, 10}, {15, 20}
        };
        int[][] nums = new int[][] {
                {7, 10}, {2, 4}
        };
        System.out.println(canAttend(nums));
    }

    public static boolean canAttend(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] arr : intervals) {
            System.out.println(Arrays.toString((arr)));
        }
        int start = 0;
        int end = 1;

        int[] prev = intervals[0];

        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[start] < prev[end]) {
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
