package meta;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public static void main(String[] args) {
        String[] arr = {"Apple", "Apple", "Orange"};
        System.out.println(find(arr));
    }

    private static int find(String[] arr) {
        Map<String, Integer> basket = new HashMap();
        int left = 0;
        int maxCount = 0;
        int right = 0;

        while (right < arr.length) {
            basket.put(arr[right], right);
            if (basket.size() > 2) {
                String strToRemove = "";
                int minIndex = Integer.MAX_VALUE;
                for (Map.Entry<String, Integer> entry : basket.entrySet()) {
                    if (entry.getValue() < minIndex) {
                        minIndex = entry.getValue();
                        strToRemove = entry.getKey();
                    }
                }
                left = minIndex + 1;
                basket.remove(strToRemove);
            }
            maxCount = Math.max(maxCount, right - left + 1);
            right++;
        }
        return maxCount;
    }
}
