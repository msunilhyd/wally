package blind75;

public class PalindromicSubstrings {

    private static int count = 0;

    public static void main(String[] args) {
        String str = "abc";
        find(str);
        System.out.println(count);
    }

    public static void find(String str) {
        for (int i=0; i<str.length(); i++) {
            countSubstrings(str, i, i);
            countSubstrings(str, i, i+1);
        }
    }

    private static void countSubstrings(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
