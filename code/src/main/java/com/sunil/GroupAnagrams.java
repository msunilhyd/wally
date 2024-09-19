package com.sunil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. Declare a list to store the list of anagrams
        List<List<String>> res = new ArrayList<>();
        // 2. Declare a hashmap to store the list of anagrams
        HashMap<String, List<String>> map = new HashMap<>();

        // 3. Traverse the string array
        for (int i=0; i<strs.length; i++) {
            // 3.1 Create a string to store the sorted string
            String sorted = sort(strs[i]);
            // 3.2 If the sorted string is already in the hashmap, add the string to the list of anagrams
            if (map.containsKey(sorted)) {
                map.get(sorted).add(strs[i]);
            } else {
                // 3.3 If the sorted string is not in the hashmap, create a new list and add the string to the list of anagrams
                List<String> list = new ArrayList();
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }
        // 4. Traverse the hashmap and add the list of anagrams to the list of anagrams
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }
        // 5. Return the list of anagrams
        return res;
    }

    // 6. Sort the string
    private String sort(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
}
