package two;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "abcabcbb";
        str = "bbbb";
        System.out.println(find(str));
    }

    public static int find(String str) {
        int l = 0;
        int r = 1;

        int maxLength = 0;

        Set<Character> set = new HashSet<>();

        set.add(str.charAt(r));
        while (r < str.length()) {
            if (set.contains(str.charAt(r))) {
                maxLength = Math.max(maxLength, set.size());
                set = new HashSet<>();
                l = r;
                set.add(str.charAt(l));
            } else
                set.add(str.charAt(r));
            r++;
        }
        return maxLength;
    }
}
