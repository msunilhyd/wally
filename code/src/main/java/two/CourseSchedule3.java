package two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule3 {

    private static Map<Integer, Set<Integer>> map = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int[][] courses = {
                {0, 1},
                {0, 2},
                {1, 2}
        };
        System.out.println(isPossible(courses));
    }

    public static boolean isPossible(int[][] courses) {
        for (int[] course : courses) {
            if (map.containsKey(course[0])) {
                Set<Integer> set = map.get(course[0]);
                set.add(course[1]);
                map.put(course[0], set);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(course[1]);
                map.put(course[0], set);
            }
        }
        for (int n : map.keySet()) {
            if (hasCycle(n) == true)
                return false;
        }
        return true;
    }

    private static boolean hasCycle(int n) {
        if (visited.contains(n))
            return true;
        if (map.get(n) == null)
            return false;

        visited.add(n);
        for (int neighbor : map.get(n)) {
            if (hasCycle(neighbor) == true)
                return true;
        }
//        visited.remove(n);
        return false;
    }
}
