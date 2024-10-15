package blind75;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms2 {

    public static void main(String[] args) {
        int[][] meetings = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(find(meetings));
    }

    public static int find(int[][] meetings) {
        int rooms = 0;
        int end = 0;

        int[] starts = new int[meetings.length];
        int[] ends = new int[meetings.length];


        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        for (int i=0; i<meetings.length; i++) {
            starts[i] = meetings[i][0];
        }

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[1]));
        for (int i=0; i<meetings.length; i++) {
            ends[i] = meetings[i][1];
        }

        for (int i=0; i<meetings.length; i++) {
            if (starts[i] < ends[end])
                rooms++;
            else
                end++;
        }
        return rooms;
    }
}
