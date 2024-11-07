package two;

import java.util.*;

public class MinWindowSubstring2 {

    public static void main(String[] args) {
        String s = "ABDICKBBDI";
        String t = "KBD";
        System.out.println(find(s, t));
    }

    private static String find(String s, String t) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        String ans = "";
        int maxLength = Integer.MAX_VALUE;
        int count = 0;
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else
                map.put(c, 1);
            set.add(c);
            count++;
        }
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                count--;
            }
            while (count == 0) {
                if (right - left < maxLength) {
                    maxLength = right - left;
                    ans = s.substring(left, right);
                }
                if(map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0)
                        count++;
                }
                left++;
            }
            right++;
        }
        return ans;
    }
}
