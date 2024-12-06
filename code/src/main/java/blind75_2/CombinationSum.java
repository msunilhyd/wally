package blind75_2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> ans = new ArrayList<>();

    private static int[] candidates;

    private static int target;

    public static void main(String[] args) {
        candidates = new int[] {2, 3, 4, 7};
        target = 7;
        dfs(0, target, new ArrayList());
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    private static void dfs(int index, int target, List<Integer> list) {
        if (target < 0)
            return;
        if (target == 0) {
            List<Integer> ansList = new ArrayList();
            ansList.addAll(list);
            ans.add(ansList);
        }
        for (int i=index; i<candidates.length; i++) {
            list.add(candidates[i]);
            dfs(index, target - candidates[i], list);
            list.removeLast();
        }
    }
}
