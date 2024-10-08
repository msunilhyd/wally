package easy;

public class PalindromeNumber {

    /*
    Determine whether an integer is a palindrome
    Can you do it without converting into a string
     */

    public boolean isPalindrome(int x) {
        int copy = x;
        int reverse = 0;
        while (copy > 0) {
            int digit = x % 10;
            reverse = reverse * 10 + digit;
            copy /= 10;
        }
        return reverse == x;
    }
}
