package two;

import java.lang.reflect.Array;

public class PalindromicSubstrings {

    private static String str = "aaa";
    private static int count = 0;

    public static void main(String[] args) {
        System.out.println(find());
    }

    public static int find() {
        for (int i=0; i<str.length(); i++) {
            count += 1;
            helper(i-1, i+1);
            helper(i-1, i);
        }
        return count;
    }

    private static void helper(int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            } else {
                break;
            }
        }
    }
}
