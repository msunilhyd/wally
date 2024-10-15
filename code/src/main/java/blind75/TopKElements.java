package blind75;

import java.lang.reflect.Array;
import java.util.*;

public class TopKElements {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 2, 3, 3, 3};
        System.out.println(find(nums, 2));
    }

    public static List<Integer> find(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList();
        Map<Integer, Set<Integer>> bucketMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
            bucketMap.put(i+1, null);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            Set<Integer> set = bucketMap.get(e.getValue());
            if (set != null) {
                set.add(e.getKey());
            } else {
                set = new HashSet();
                set.add(e.getKey());
                bucketMap.put(e.getValue(), set);
            }
        }

        for (int i=bucketMap.size()-1; i>=0; i--) {
            Set<Integer> set = bucketMap.get(i);
            if (set != null) {
                result.addAll(set);
            }
            if (result.size() == k)
                return result;
        }
        return result;
    }
}
