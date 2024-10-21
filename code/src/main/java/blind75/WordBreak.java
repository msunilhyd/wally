package blind75;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String str = "leetcode";
        String[] dict = {"leet", "code"};
        System.out.println(find(str, dict));
    }

    public static boolean find(String str, String[] dict) {
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(dict));

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        int i;
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (!queue.contains(start)) {
                for (i=start+1; i<=str.length(); i++) {
                    if (set.contains(str.substring(start, i))) {
                        if (i == str.length())
                            return true;
                        queue.add(i);
                    }
                }
                visited.add(start);
            }
        }
        return false;
    }
}
