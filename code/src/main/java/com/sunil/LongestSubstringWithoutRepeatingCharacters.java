package com.sunil;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstringWithoutRepeatingCharacters (String s){
        // 1. If length of string is 0, no substring
        if (s.length() == 0)
            return 0;
        // 2. Create a hashmap to store the index of each character in the string
        HashMap<Character, Integer> map = new HashMap();
        int max = 0;
        // 3. Create a pointer to traverse the string
        for (int i=0, j=0; i<s.length(); ++i) {
            // 3. 1 If the character is already in the hashmap, update the index of the character
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // 3.2 Update the hashmap with the current index of the character
            map.put(s.charAt(i), i);
            // 3.3 Update the max length of the substring
            max = Math.max(max, i-j+1);
        }
        // 4. Return the max length of the substring
        return max;
    }
}
