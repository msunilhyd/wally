package blind75_2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinWindowSubstring2 {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(find(s, t));
    }

    private static String find(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";

        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else
                map.put(c, 1);
        }
        int count = map.size();
        while (right < s.length()) {
            char rChar = s.charAt(right);
            if (map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) - 1);
                if (map.get(rChar) == 0)
                    count--;
            }
            right++;
            while (count == 0) {
                if (right - left < min) {
                    min = right - left;
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
