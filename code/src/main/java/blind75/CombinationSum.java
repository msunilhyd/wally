package blind75;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static int[] candidates;
    private static int target;
    private static List<List<Integer>> lists = new ArrayList<>();

    public static void main(String[] args) {
        candidates = new int[]{2, 3, 6, 7};
        target = 7;
        dfs(0, target, new ArrayList<>());
        for(List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public static void dfs(int start, int curVal, List<Integer> curList) {
        if (curVal < 0)
            return;
        if (curVal == 0) {
            List<Integer> list = new ArrayList();
            list.addAll(curList);
            lists.add(list);
        }
        for (int i=start; i<candidates.length; i++) {
            curList.add(candidates[i]);
            dfs(i, curVal - candidates[i], curList);
            curList.removeLast();
        }
    }
}
