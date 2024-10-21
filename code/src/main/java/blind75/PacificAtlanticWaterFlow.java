package blind75;

import java.util.*;

public class PacificAtlanticWaterFlow {

    private static int[][] heights;
    public static void main(String[] args) {
        heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        for (int[] arr : find()) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public static List<int[]> find() {
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();

        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (i == 0 || j == 0)
                    pacific.add(new int[]{i, j});
                if (i == heights.length - 1 || j == heights[0].length - 1)
                    atlantic.add(new int[]{i, j});
            }
        }
        int[][] pacificTrue = bfs(pacific);
        int[][] atlanticTrue = bfs(atlantic);
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (pacificTrue[i][j] == 1 && atlanticTrue[i][j] == 1)
                    res.add(new int[]{i, j});
            }
        }
        return res;
    }

    private static int[][] bfs(Queue<int[]> queue) {
        int[][] neighbors = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int[][] pacificTrue = new int[heights.length][heights[0].length];
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            pacificTrue[curr[0]][curr[1]] = 1;
            for (int[] neigh : neighbors) {
                int[] next = new int[] {curr[0] + neigh[0], curr[1] + neigh[1]};
                int nextX = curr[0] + neigh[0];
                int nextY = curr[1] + neigh[1];
                if (!isValid(nextX, nextY) || pacificTrue[next[0]][next[1]] == 1)
                    continue;
                if (heights[nextX][nextY] >= heights[curr[0]][curr[1]]) {
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return pacificTrue;
    }
    private static boolean isValid(int x, int y) {
        if (x >=0 && x < heights.length && y >= 0 && y < heights[0].length)
            return true;
        return false;
    }
}
