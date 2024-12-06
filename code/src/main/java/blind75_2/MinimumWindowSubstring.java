package blind75_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANCA";
        String t = "ABC";
        System.out.println(find(s, t));
    }

    private static String find(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else
                map.put(c, 1);
        }
        int count = map.size();
        int left = 0;
        int right = 0;
        String ans = "";
        int minVal = Integer.MAX_VALUE;
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0)
                    count--;
            }
            right++;
            while (count == 0) {
                if (right - left < minVal) {
                    minVal = right - left;
                    ans = s.substring(left, right);
                }
                char lChar = s.charAt(left);
                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                    if (map.get(lChar) > 0)
                        count++;
                }
                left++;
            }
        }
        return ans;
    }
}
