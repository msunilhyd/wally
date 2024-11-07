package two;

import java.util.*;

public class PacificAtlanticWaterFlow {

    private static int[][] matrix;
    private static int[][] pacific;
    private static int[][] atlantic;

    public static void main(String[] args) {
        matrix = new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        for (int[] entry : find()) {
            System.out.println(Arrays.toString(entry));
        }
    }

    private static List<int[]> find() {

        pacific = new int[matrix.length][matrix[0].length];
        atlantic = new int[matrix.length][matrix[0].length];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    pacificQueue.add(new int[] {i, j});
                }
                if (i == matrix[0].length-1 || j == matrix[0].length-1) {
                    atlanticQueue.add(new int[] {i, j});
                }
            }
        }

        dfs(pacific, pacificQueue);
        dfs(atlantic, atlanticQueue);

        List<int[]> res = new ArrayList<>();

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] ocean, Queue<int[]> queue) {
        int[][] neighbors = new int[][] {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0];
            int j = cell[1];
            if (isValid(i, j)) {
                for(int[] neighbor : neighbors) {
                    int nextX = i + neighbor[0];
                    int nextY = j + neighbor[1];
                    if (!isValid(nextX, nextY) || ocean[nextX][nextY] == 1)
                        continue;
                    if (matrix[i][j] <= matrix[nextX][nextY]) {
                        ocean[nextX][nextY] = 1;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
        }
    }

    private static boolean isValid(int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return false;
        }
        return true;
    }
}
