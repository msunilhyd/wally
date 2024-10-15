package blind75;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(find(3));
    }

    public static int find(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
