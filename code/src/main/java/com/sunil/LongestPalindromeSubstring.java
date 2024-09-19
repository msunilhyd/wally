package com.sunil;

public class LongestPalindromeSubstring {

    public String longestPalindrome(String s) {
        // 1. If string is empty or has only 1 character return string
        if (s == null || s.length() < 1)
            return "";
        // 2. Declare left and right pointers
        int left = 0;
        int right = 0;
        // 3. Traverse the string
        for (int i=0; i<s.length(); i++) {
            // 3.1 Find the longest palindrome with odd length
            int len1 = expandAroundCenter(s, i, i);
            // 3.2 Find the longest palindrome with even length
            int len2 = expandAroundCenter(s, i, i+1);
            // 3.3 Find the longest palindrome between two found lengths
            int len = Math.max(len1, len2);
            // 3.4 If the length is greater than the current length, update the left and right pointers
            if (len > right - left) {
                // 3.4.1 Update the left pointer
                left = i - (len - 1) / 2;
                // 3.4.2 Update the right pointer
                right = i + len / 2;
            }
        }
        // 4. Return the substring between left and right pointers
        return s.substring(left, right - 1);
    }

    // Method to expand around center until a palindrome is found
    // Return the length of the palindrome
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right <=s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
