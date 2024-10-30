package two;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][] intervals = {{2, 4}, {7, 10}};
        System.out.println(canAttend(intervals));
    }

    public static boolean canAttend(int[][] intervals) {
        int[] prev = intervals[0];
        for (int i=1; i<intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] < prev[1])
                return false;
            prev = curr;
        }
        return true;
    }
}
