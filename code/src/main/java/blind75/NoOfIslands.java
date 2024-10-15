package blind75;

public class NoOfIslands {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};
        System.out.println(countIslands(arr));
    }

    public static int countIslands(int[][] arr) {
        int count = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                if (arr[i][j] == 1)
                    count = count + dfs(arr, i, j);
            }
        }
        return count;
    }

    public static int dfs(int[][] arr, int i, int j)  {
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length-1 || arr[i][j] == 0)
            return 0;
        arr[i][j] = 0;
        dfs(arr, i+1, j);
        dfs(arr, i-1, j);
        dfs(arr, i, j+1);
        dfs(arr, i, j-1);
        return 1;
    }
}
