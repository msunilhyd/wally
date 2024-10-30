package two;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] words = {"cat", "tac", "act", "book", "obok"};
        System.out.println(find(words));

    }

    public static List<List<String>> find(String[] words) {
        String[] sortedWords = new String[words.length];
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            sortedWords[i] = new String(charArr);
        }
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i< sortedWords.length; i++) {
            if (map.containsKey(sortedWords[i]))
                map.get(sortedWords[i]).add(words[i]);
            else {
                List<String> list = new ArrayList<>();
                list.add(sortedWords[i]);
                map.put(sortedWords[i], list);
            }
        }
        List<List<String>> res = new ArrayList<>();

        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
