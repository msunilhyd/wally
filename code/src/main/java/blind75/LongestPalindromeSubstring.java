package blind75;

public class LongestPalindromeSubstring {

    public static void main(String[] args) {
        System.out.println(find("cbbd"));
    }

    public static String find(String str) {
        String longest = "";

        for (int i=0; i<str.length(); i++) {
            String oddPalindrome = palindromeString(str, i, i);
            String evenPalindrome = palindromeString(str, i, i+1);

            String longestPalidrome = oddPalindrome.length() > evenPalindrome.length() ? oddPalindrome : evenPalindrome;

            longest = longestPalidrome.length() > longest.length() ? longestPalidrome : longest;
        }
        return longest;
    }

    public static String palindromeString(String str, int left, int right) {
        while (left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
