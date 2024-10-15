package blind75;

import java.util.*;

public class NoOfConnectedComponents {

    private static Map<Integer, List<Integer>> map = new HashMap<>();
    private static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        countNoOfConnectedComponents(5, edges);
    }

    public static void countNoOfConnectedComponents(int n, int[][] edges) {
        int count = 0;

        for (int i=0; i<n; i++) {
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        for(int i : map.keySet()) {
            count += dfs(i);
        }

        System.out.println("No. of connected components = " + count);
    }

    public static int dfs(int n) {
        if (set.contains(n))
            return 0;

        set.add(n);
        for (int k : map.get(n)) {
            dfs(k);
        }
        return 1;
    }
}
