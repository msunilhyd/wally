package com.sunil;

public class MinWindowSubstring {

    public String minWindow(String s, String t) {
        // 1. Create a hashmap to store the characters of t and their counts. 128 to utilize charset of alphabet length
        int[] map = new int[128];
        // 2. Initialize the hashmap with the characters of t
        for (char c:t.toCharArray()) {
            map[c]++;
        }
        // 3. Initialize the start and end pointers. As well as head and tail
        int counter = t.length();
        int begin = 0, end = 0;
        int head = 0, tail = 0;
        int min = Integer.MAX_VALUE;
        // 4. Loop through the string s
        while (end < s.length()) {
            // 4.1 Cache the character at the end pointer
            char c = s.charAt(end);
            // 4.2 Move end pointer forward
            end++;
            // 4.3 If the cached value exists in current map then decrement the counter
            if (map[c] > 0) {
                counter--;
            }
            // 4.4 Decrement the frequency of the cached character
            map[c]--;
            // 4.5 While the counter is 0, move the head pointer forward
            while(counter == 0) {
                // 4.5.1 If the length of the substring is less than minimum, update minimum and update head and tail
                if (end - begin < min) {
                    min = end - begin;
                    head = begin;
                    tail = end;
                }
                // 4.5.2 Cache the character at the begin pointer
                c = s.charAt(begin);
                // 4.5.3 Move begin pointer forward
                begin++;
                // 4.5.4 If the cached value does not exist in current map then increment the counter
                if (map[c] == 0) {
                    counter++;
                }
                // 4.5.5 Increment the freq of the cached character
                map[c]++;
            }
        }
        //7. Return the substring
        return min == Integer.MAX_VALUE ? "" : s.substring(head, tail);
    }
}
