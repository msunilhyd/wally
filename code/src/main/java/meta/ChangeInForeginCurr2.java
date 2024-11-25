package meta;

import java.util.Arrays;

public class ChangeInForeginCurr2 {

    public static void main(String[] args) {

        int[] arr = {2, 3};

        int target = 4;
        System.out.println(possible(arr,target));
    }

    public static boolean possible(int[] arr, int target) {
        if (target == 0 || arr.length == 0)
            return true;

        Arrays.sort(arr);
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int coin : arr) {
            for (int amt=coin; amt<=target; amt++) {
                System.out.println(amt);
                if (dp[amt - coin])
                    dp[amt] = true;
            }
        }
        return dp[target];
    }
}
