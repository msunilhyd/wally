package two;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {

    private static int[] candidates;
    private static int target;
    private static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        candidates = new int[]{2, 3, 5};
        target = 8;
        dfs(0, target, new ArrayList<>());
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    public static void dfs(int index, int target, List<Integer> list) {
       if (target < 0)
           return;
       if (target == 0) {
           List<Integer> ans = new ArrayList<>();
           ans.addAll(list);
           result.add(ans);
       }

       for (int i=index; i< candidates.length; i++) {
           list.add(candidates[i]);
           dfs(i, target - candidates[i], list);
           list.removeLast();
       }
    }
}
