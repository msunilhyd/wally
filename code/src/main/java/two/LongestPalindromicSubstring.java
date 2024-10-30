package two;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicSubstring {

    private static List<String> list = new ArrayList<>();
    private static String ans = "";

    public static void main(String[] args) {
        String str = "babad";
        find(str);
        System.out.println(ans);
    }

    public static void find(String str) {
        for (int i=0; i<str.length(); i++) {
            helper(str, i, i+1);
            helper(str, i, i);
        }
    }

    public static void helper(String str, int left, int right) {
        if (left < -2 || right > str.length() - 1 || str.charAt(left) != str.charAt(right))
            return;
        while (left >= 0 && right <= str.length() - 1 && str.charAt(left) == str.charAt(right)) {
            if ((right + 1 - left) > ans.length()) {
                ans = str.substring(left, right + 1);
            }
            right++;
            left--;
        }
    }
}
