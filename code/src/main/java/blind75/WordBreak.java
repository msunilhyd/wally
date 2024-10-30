package blind75;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        System.out.println(solve(str, dict));
    }

    public static String solve(String str, List<String> dict) {
        Set<String> set = new HashSet<>();
        set.addAll(dict);

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
                            return "true";
                        queue.add(i);
                    }
                }
                visited.add(start);
            }
        }
        return "false";
    }
}
