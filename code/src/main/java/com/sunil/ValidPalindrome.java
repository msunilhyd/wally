package com.sunil;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("abrkba"));
    }

    public static boolean isPalindrome(String s) {
        // 1. Make all the characters in string of same case
        s = s.toLowerCase();
        // 2. Convert the string to charArray
        char[] arr = s.toCharArray();
        // 3. declare pointers for the left and right end of the string
        int left = 0;
        int right = s.length() - 1;

        // 4. While the left pointer is less than the right
        while (left < right) {
            // 4.1 If the arr[right] is not alphanumeric, move the right pointer to the left by 1 step
            while (left < right && !Character.isLetterOrDigit(arr[right]))
                right--;
            // 4.2 If the arr[left] is not alphanumeric, move the left pointer to the right by one step
            while (left < right && !Character.isLetterOrDigit(arr[left]))
                left++;
            if (arr[left++] != arr[right--])
                return false;
        }
        return true;
    }
}
