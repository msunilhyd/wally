package two;

public class DecodeWays {

    public static void main(String[] args) {
        String str = "226";
        System.out.println(find(str));
    }

    public static int find(String str) {
        if (str == null || str.length() == 0)
            return 0;
        if (str.charAt(0) == '0')
            return 0;
        int[] dp = new int[str.length() + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=str.length(); i++) {
            int oneDigit = Integer.parseInt(str.substring(i-1, i));
            int twoDigit = Integer.parseInt(str.substring(i-2, i));

            if (oneDigit >=1 && oneDigit <=9)
                dp[i] = dp[i] + dp[i-1];
            if (twoDigit >=10 && twoDigit <= 26)
                dp[i] = dp[i] + dp[i-2];
        }
        return dp[str.length()];
    }
}
