package meta;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ChangeInForeignCurrency{

    // Method to determine if exact change can be made for targetMoney
    public static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // If targetMoney is 0, we can always make exact change (give nothing)
        if (targetMoney == 0) {
            return true;
        }

        // Sort denominations for efficient processing (not strictly necessary)
        Arrays.sort(denominations);

        // Create an array to keep track of achievable amounts up to targetMoney
        boolean[] dp = new boolean[targetMoney + 1];
        dp[0] = true; // Base case: we can make 0 amount with no coins

        // Iterate through each denomination
        for (int coin : denominations) {
            // Update the dp array for each amount from coin to targetMoney
            for (int amount = coin; amount <= targetMoney; amount++) {
                System.out.println("amount = " + amount + ", coin = " + coin);
                if (dp[amount - coin]) {
                    dp[amount] = true; // If we can make 'amount - coin', we can make 'amount'
                }
            }
            System.out.println(Arrays.toString(dp));
        }

        // The result is whether we can make 'targetMoney'
        return dp[targetMoney];
    }

    // Example usage
    public static void main(String[] args) {
        int targetMoney = 4;
        int[] denominations = {2, 3}; // Example denominations

        boolean canMakeChange = canGetExactChange(targetMoney, denominations);
        System.out.println("Can make exact change for " + targetMoney + ": " + canMakeChange);
    }
}
