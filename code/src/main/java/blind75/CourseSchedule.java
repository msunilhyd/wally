package blind75;

import java.util.*;

public class CourseSchedule {

    public static Map<Integer, List<Integer>> map = new HashMap<>();
    public static Set<Integer> visited = new HashSet<>();

    public static void main(String[] args) {
        int[][] preReqs = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        System.out.println((find(3, preReqs)));
    }

    public static boolean find(int n, int[][] preReqs) {
        for (int i=0; i<preReqs.length; i++) {
            int[] curPreReq = preReqs[i];
            if (map.containsKey(curPreReq[0])) {
                List<Integer> value = map.get(curPreReq[0]);
                value.add(curPreReq[1]);
            } else {
                List<Integer> value = new ArrayList<>();
                value.add(curPreReq[1]);
                map.put(curPreReq[0], value);
            }
        }
        System.out.println(map);
        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            if (!dfs(e.getKey()))
                return false;
        }
        return true;
    }

    public static boolean dfs(int n) {
        if (visited.contains(n))
            return false;
        if (map.get(n) == null)
            return true;

        visited.add(n);

        for (int i : map.get(n)) {
            if (dfs(i) == false)
                return false;
        }
        visited.remove(n);
        map.put(n, null);
        return true;
    }
}
