package blind75_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2, 3, 4, 7};
        List<List<Integer>> res = combinationSum(candidates, 7);
        for(List<Integer> list : res) {
            System.out.println(res);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int index, List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
