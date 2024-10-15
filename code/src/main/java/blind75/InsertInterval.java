package blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
       List<int[]> intervals = new ArrayList<>();
       intervals.add(new int[]{1, 2});
       intervals.add(new int[]{3, 5});
       intervals.add(new int[]{6, 7});
       intervals.add(new int[]{8, 10});
       intervals.add(new int[]{12, 16});

       insertInterval(intervals, new int[]{4, 8});
    }

    public static void insertInterval(List<int[]> intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList();
        int start = 0;
        int end = 1;
        int i = 0;

        while (i <intervals.size() && intervals.get(i)[end] < newInterval[start]) {
            ansList.add(intervals.get(i));
            i++;
        }

        while (i < intervals.size() &&  intervals.get(i)[start] <= newInterval[end]){
            newInterval[start] = Math.min(newInterval[start], intervals.get(i)[start]);
            newInterval[end] = Math.max(newInterval[end], intervals.get(i)[end]);
            i++;
        }
        ansList.add(newInterval);
        while (i < intervals.size()) {
            ansList.add(intervals.get(i));
            i++;
        }
        for (int[] arr : ansList) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
