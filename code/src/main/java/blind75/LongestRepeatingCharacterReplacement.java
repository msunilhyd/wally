package blind75;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String str = "ABAB";
        System.out.println(find(str, 2));
    }

    public static int find(String str, int k) {
        int longest = 0;
        int mostFrequent = 0;

        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();

        while (right < str.length()) {
            char charAtRight = str.charAt(right);
            if (map.containsKey(charAtRight)) {
                map.put(charAtRight, map.get(charAtRight) + 1);
            } else
                map.put(charAtRight, 1);
            mostFrequent = Math.max(mostFrequent, map.get(charAtRight));

            while ((right - left + 1) - mostFrequent > k) {
                char charAtLeft = str.charAt(left);
                map.put(charAtLeft, map.get(charAtLeft) - 1);
                left++;
            }

            longest = Math.max(longest, (right - left + 1));
            right++;
        }
        return longest;
    }
}
