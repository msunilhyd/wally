package blind75_3;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 5, 2};
        System.out.println(find(coins, 5));
    }

    private static int find(int[] coins, int target) {
        int[] dp = new int[target + 1];
        Arrays.sort(coins);
        dp[0] = 0;
        for (int i=1; i<=target; i++) {
            for (int coin : coins) {
                if (i - coin < 0)
                    break;
                dp[i] = 1 + dp[i - coin];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
}
