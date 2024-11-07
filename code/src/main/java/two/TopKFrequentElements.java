package two;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4};
        int k = 2;
        System.out.println(find(nums, k));
    }

    public static List<Integer> find(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        Map<Integer, Set<Integer>> bucket = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            bucket.put(i, new HashSet<>());
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Set<Integer> set = bucket.get(e.getValue()) ;
            set.add(e.getKey());
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=nums.length-1; i>0; i--) {
            Set<Integer> set = bucket.get(i);
            ans.addAll(set);
            if (ans.size() > k)
                break;
        }
        List<Integer> res = new ArrayList<>();
        for (int i=0; i<ans.size(); i++) {
            if (res.size() >= k)
                break;
            res.add(ans.get(i));
        }
        return res;
    }
}
