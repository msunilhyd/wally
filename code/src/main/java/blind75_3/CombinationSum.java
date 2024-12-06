package blind75_3;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    private static int[] candidates;

    private static List<List<Integer>> res = new ArrayList();

    public static void main(String[] args) {
        candidates = new int[] {2, 3, 4, 7};
        dfs(7, 0, new ArrayList());
        for (List<Integer> list : res)
            System.out.println(list);
    }


    private static void dfs(int target, int index, List<Integer> curList) {
        if (target < 0 || index == candidates.length)
            return;
        if (target == 0) {
            List<Integer> ansList = new ArrayList<>();
            ansList.addAll(curList);
            res.add(ansList);
            return;
        }
        for (int i = index; i<candidates.length; i++) {
            curList.add(candidates[i]);
            dfs(target - candidates[i], i, curList);
            curList.removeLast();
        }
    }
}
