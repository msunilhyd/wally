package blind75;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        for (List<String> list : groupAnag(strs)) {
            System.out.println(list);
        }
    }

    public static List<List<String>> groupAnag(String[] strs) {
        String[] sortedStrArr = new String[strs.length];
        for (int i=0; i<strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            sortedStrArr[i] = new String(arr);
        }
        Map<String, List<String>> map = new HashMap();
        for (int i=0; i<sortedStrArr.length; i++) {
            if (map.containsKey(sortedStrArr[i])) {
                List<String> value = map.get(sortedStrArr[i]);
                value.add(strs[i]);
            } else {
                List<String> value = new ArrayList<>();
                value.add(strs[i]);
                map.put(sortedStrArr[i], value);
            }
        }
        List<List<String>> list = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, List<String>> e : map.entrySet()) {
            list.add(e.getValue());
        }
//        System.out.println(map);
//        System.out.println(Arrays.toString(sortedStrArr));
        return list;
    }
}
