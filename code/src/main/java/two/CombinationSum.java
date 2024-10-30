package two;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> result = new ArrayList<>();
    private static int[] candidates;

    private static int target;

    public static void main(String[] args) {
        candidates = new int[]{2, 3, 6, 7};
        target = 7;
        dfs(0, target, new ArrayList<>());
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static void dfs(int index, int currentVal, List<Integer> list) {
        if (currentVal < 0)
            return;
        if (currentVal == 0) {
            List<Integer> res = new ArrayList<>();
            res.addAll(list);
            result.add(res);
        }

        for (int i=index; i<candidates.length; i++) {
            list.add(candidates[i]);
            dfs(i, currentVal - candidates[i], list);
            list.removeLast();
        }
    }
}
