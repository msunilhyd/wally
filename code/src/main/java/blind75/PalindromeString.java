package blind75;

import com.sun.security.jgss.GSSUtil;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(isPalindrome(cleanUp("09lir,-il90")));
    }

    public static String cleanUp(String str) {
        String s = "abcdefghijklmnopqrstuvwxyz0123456789";
        String returnString = "";
        str = str.toLowerCase();
        for (int i=0; i<str.length(); i++) {
            if (s.indexOf(str.charAt(i)) != -1)
                returnString += str.charAt(i);
        }
        return returnString;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            }
            else
                return false;
        }
        return true;
    }
}
