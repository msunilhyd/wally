package blind75;

import java.util.*;

public class PacificAtlantic {

    private static int[][] heights;

    public static void main(String[] args) {

        heights = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        find();
    }

    public static List<int[]> find() {
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (i == 0 || j == 0) {
                    pacific.add(new int[]{i, j});
                }
                if (i == heights.length -1 || j == heights[0].length - 1) {
                    atlantic.add(new int[]{i, j});
                }
            }
        }
        int[][] pacificMatrix = bfs(pacific);
        int[][] atlanticMatrix = bfs(atlantic);

        List<int[]> res = new ArrayList<>();
        for (int i=0; i<heights.length; i++) {
            for (int j=0; j<heights[0].length; j++) {
                if (pacificMatrix[i][j] == 1 && atlanticMatrix[i][j] == 1)
                    res.add(new int[]{i, j});
            }
        }
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
        return res;
    }

    public static int[][] bfs(Queue<int[]> queue) {

        int[][] visited = new int[heights.length][heights[0].length];
        int[][] neighbours = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
//            System.out.println(Arrays.toString(curr));
            int currX = curr[0];
            int currY = curr[1];
            visited[currX][currY] = 1;

            for (int[] neigh : neighbours) {
                int nextX = currX + neigh[0];
                int nextY = currY + neigh[1];
                int[] neighArr = new int[] {nextX, nextY};
                if (!isValid(nextX, nextY) || visited[nextX][nextY] == 1)
                    continue;
                if (heights[nextX][nextY] >= heights[currX][currY])
                    queue.add(neighArr);
            }
        }
        return visited;
    }

    public static boolean isValid(int i, int j) {
        if (i >= 0 && i < heights.length && j >=0 && j < heights[0].length)
            return true;
        return false;
    }
}
