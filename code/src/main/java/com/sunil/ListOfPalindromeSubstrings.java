package com.sunil;

public class ListOfPalindromeSubstrings {
    public int countSubStrings(String s) {
        // 1. Declare a count variable to store the number of substrings
            int count = 0;
        // 2. Traverse the string
        for (int i=0; i<s.length(); i++) {
            // 2.1 Find the number of substrings with odd length add to the count
            count += expandAroundCenter(s, i, i);
            // 2.2 Find the number of substrings with even length add to the count
            count += expandAroundCenter(s, i, i+1);
        }
        return count;
    }

    // Method to extract palindrome from a string
    public int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
            left--;
            right++;
            // There is a palindrom everytime it is expanded
            count++;
        }
        return count;
    }
}
