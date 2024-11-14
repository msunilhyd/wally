package meta2;

import java.util.HashMap;
import java.util.Map;

public class SumPairs {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 3, 5};
        System.out.println(find(nums, 6));
    }

    private static int find(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else
                map.put(n, 1);
        }
        System.out.println(map);
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(target - entry.getKey())) {
                if (target - entry.getKey() == entry.getKey()) {
                    int val = entry.getValue();
                    count += val * (val-1)/2;
                }
                else if(map.get(target - entry.getKey()) != -1) {
                    count++;
                    map.put(entry.getKey(), -1);
                }
            }
        }
        return count;
    }
}
