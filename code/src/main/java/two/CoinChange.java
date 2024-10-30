package two;

public class CoinChange {
    public static int[] coins = {1, 2, 5};
    public static int target = 3;
    public static void main(String[] args) {
        System.out.println(find());
    }

    public static int find() {
        int[] dp = new int[target+1];
        dp[0] = 0;
        for (int i=1; i<dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<=target; i++) {
            for (int coin : coins) {
                if (i < coin)
                    continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-coin]);
            }
        }
        return dp[target];
    }
}
