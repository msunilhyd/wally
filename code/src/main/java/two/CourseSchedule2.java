package two;

import java.util.*;

public class CourseSchedule2 {

    private static Map<Integer, List<Integer>> map = new HashMap<>();
    private static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int[][] courses = new int[][] {
                {0, 1},
                {0, 2},
                {1, 0}
        };
        System.out.println(canComplete(courses));
    }

    private static boolean canComplete(int[][] courses) {
        for (int[] course : courses) {
            if (map.containsKey(course[0])) {
                map.get(course[0]).add(course[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(course[1]);
                map.put(course[0], list);
            }
        }

        for (int n : map.keySet()) {
            if (dfs(n) == false)
                return false;
        }
        return true;
    }

    private static boolean dfs(int n) {
        if (map.get(n) == null)
            return true;
        if (visited.contains(n))
            return false;

        visited.add(n);

        for (int neighbor : map.get(n)) {
            if (dfs(neighbor) == false)
                return false;
        }
        visited.remove(n);
        return true;
    }
}
