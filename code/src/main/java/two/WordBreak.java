package two;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        String str = "applepenapple";
        String[] words = {"apple", "pen"};
        System.out.println(find(str, words));
    }

    private static boolean find(String str, String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        int left = 0;
        int right = 0;

        while (right < str.length()) {
            if (set.contains(str.substring(left, right+1))) {
                left = right+1;
            }
            right++;
        }
        if (left == right)
            return true;
        return false;
    }
}
