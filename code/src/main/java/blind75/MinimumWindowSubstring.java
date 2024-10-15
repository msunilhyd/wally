package blind75;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    // Time complexity = O(s + t)
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(find(s, t));
    }

    public static String find(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        for (Character c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int left = 0;
        int right = 0;
        int count = map.size();
        int len = Integer.MAX_VALUE;
        String minString = "";

        while (right < s.length()) {
            Character rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0)
                    count--;
            }
            right++;

            while (count == 0) {
                if (right - left < len) {
                    len = right - left;
                    minString = s.substring(left, right);
                }
                char leftChar = s.charAt(left);
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0)
                        count++;
                }
                left++;
            }
        }
        return minString;
    }
}