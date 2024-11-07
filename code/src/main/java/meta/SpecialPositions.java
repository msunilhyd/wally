package meta;

public class SpecialPositions {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };
        System.out.println(numSpecial(mat));
    }

    public static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                rows[i] = rows[i] + mat[i][j];
                cols[j] = cols[j] + mat[i][j];
            }
        }

        int ans = 0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
