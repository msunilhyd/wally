package two;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatedCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(find("AABABA", 2));
    }

    public static int find(String str, int k) {

        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int longest = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {
            char rChar = str.charAt(right);
            if (map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) + 1);
                maxFreq = Math.max(maxFreq, map.get(rChar));
            } else {
                map.put(rChar, 1);
            }

            while ((right - left + 1) - maxFreq > k) {
                char lChar = str.charAt(left);
                map.put(lChar, map.get(lChar) - 1);
                maxFreq = Math.max(maxFreq, map.get(lChar));
                left++;
            }
            longest = Math.max(right - left + 1, longest);
            right++;
        }
        return longest;
    }
}
