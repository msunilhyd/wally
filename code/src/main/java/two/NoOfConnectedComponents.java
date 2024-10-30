package two;

import java.util.*;

public class NoOfConnectedComponents {

    private static Set<Integer> visited = new HashSet<>();
    private static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4},
                {6, 5}
        };
        System.out.println(find(n, edges));
    }

    public static int find(int n, int[][] edges) {
        int start = 0;
        int end = 1;
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            map.get(edge[start]).add(edge[end]);
            map.get(edge[end]).add(edge[start]);
        }
        int count = 0;
        for (int i : map.keySet()) {
            count = count + dfs(i);
        }
        return count;
    }

    private static int dfs(int i) {
        if (visited.contains(i))
            return 0;

        visited.add(i);
        for (int neighbor : map.get(i)) {
           dfs(neighbor);
        }
        return 1;
    }
}
