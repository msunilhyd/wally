package meta;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSumPairs {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3};
        int target = 6;
        System.out.println(find(nums, target));
    }

    private static int find(int[] nums, int target) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else
                map.put(n, 1);
        }
        System.out.println(map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(target - entry.getKey())) {
                if ((target - entry.getKey() == entry.getKey())) {
                    int val = entry.getValue();
                    count += val * (val - 1) / 2;
                } else {
                    if (entry.getValue() != -1 && map.get(target - entry.getKey()) != -1) {
                        count++;
                        map.put(entry.getKey(), -1);
                    }
                }
            }
        }
        return count;
    }
}
