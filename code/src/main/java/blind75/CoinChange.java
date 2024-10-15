package blind75;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(getNoOfCoins(3, coins));
    }

    public static int getNoOfCoins(int n, int[] coins) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i=1; i<=n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i=1; i<=n; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] > i)
                    break;
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }
        return dp[n] < Integer.MAX_VALUE ? dp[n] : -1;
    }
}
