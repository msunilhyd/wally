package blind75;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    // Time Complexity = O(n)
    public static void main(String[] args) {
        Integer[] arr = {100, 4, 200, 1, 2, 3, 101, 102, 99, 98, 97};
        System.out.println(find(arr));
    }

    public static int find (Integer[] nums) {
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(nums));

        int streak = 0;

        for (int n : set) {
            if (set.contains(n-1))
                continue;
            int currentStreak = 1;
            while (set.contains(n + 1)) {
                currentStreak++;
                n++;
            }
            streak = Math.max(streak, currentStreak);
        }
        return streak;
    }
}
