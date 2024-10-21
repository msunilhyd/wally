package blind75;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(find(5)));
        String str = "2024-10-17";
        String str2 = java.time.LocalDate.now().toString();
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str.equals(str2));
    }

    public static int[] find (int n) {
        int[] dp = new int[n+1];
        int offset = 1;

        for (int i=1; i<=n; i++) {
            if (offset * 2 == i)
                offset = i;
            dp[i] = 1 + dp[i-offset];
        }
        return dp;
    }
}
