package blind75;

import java.util.*;

public class LongestSubstringWithoutRepeatingChars {

    public static void main(String[] args) {
        System.out.println(find("pwwkew"));
    }

    public static int find(String str) {
        int length = 0;
        int left = 0;
        int right = 0;

        Set<Character> set = new HashSet<>();

        while (right <= str.length() - 1) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                length = Math.max(length, set.size());
                right++;
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }
        return length;
    }
}


