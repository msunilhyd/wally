package blind75;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(find(grid));
    }

    private static int find(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{0, 0, 1});
        grid[0][0] = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int[] point = q.poll();
                if (point[0] == m-1 && point[1] == n-1)
                    return point[2];
                for (int[] d : dirs) {
                    int dx = point[0] + d[0];
                    int dy = point[1] + d[1];
                    if (dx >=0 && dx < m && dy >=0 && dy < n && grid[dx][dy] == 0) {
                        q.offer(new int[]{dx, dy, point[2] + 1});
                        grid[dx][dy] = 1;
                    }
                }
            }
        }
        return -1;
    }
}
