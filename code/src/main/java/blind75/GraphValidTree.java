package blind75;

import java.util.*;

public class GraphValidTree {

    public static Set<Integer> visited = new HashSet<>();
    public static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        int[][] preReqs = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}, {4, 0}};
        System.out.println(("isValid Graph Tree = " + find(5, preReqs)));
    }

    public static boolean find(int n, int[][] edges) {
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        if (hasCycle(0, -1)) {
            return false;
        }

        if (visited.size() < n)
            return false;

        return true;
    }

    public static boolean hasCycle(int current, int parent) {
        visited.add(current);
        for (int neighbor : map.get(current)) {
            if (visited.contains(neighbor) && neighbor != parent)
                return true;
            else
                if (neighbor != parent && hasCycle(neighbor, current))
                    return true;
        }

        return false;
    }
}
