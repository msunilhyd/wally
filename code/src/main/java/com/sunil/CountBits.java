package com.sunil;

public class CountBits {

    public int[] countBits(int n) {
        int[] dp = new int[n+1]; // dp[i] is the number of 1s in i
        dp[0] = 0;

        for (int i=1; i<=n; i++) {
            dp[i] = dp[i/2]+i%2; // if i is odd then we have 1 more 1 than if i is even
        }
        return dp;
    }
}
