package blind75;

public class DecodeWays {

    public static void main(String[] args) {
        String str = "12";
        System.out.println(find(str));
    }

    public static int find(String str) {
        if (Integer.parseInt(str.substring(0, 1)) == 0)
            return 0;
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=str.length(); i++) {
            int single = Integer.parseInt(str.substring(i-1, i));
            int doublee = Integer.parseInt(str.substring(i-2, i));

            if (single >= 1 && single <=9)
                dp[i] = dp[i] + dp[i-1];
            if (doublee >= 10 && doublee <=26)
                dp[i] = dp[i] + dp[i-2];
        }
        return dp[str.length()];
    }
}
