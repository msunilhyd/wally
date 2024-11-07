package two;

import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord {

    public static void main(String[] args) {
        Map<Character, HashMap> map = new HashMap();
        add(map, "sunil");
        System.out.println(search(map, "sunil", 0));
    }

    private static void add(Map<Character, HashMap> map, String word) {
        for (char c : word.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, new HashMap());
            map = map.get(c);
        }
    }

    private static boolean search(Map<Character, HashMap> map, String word, int index) {
        if (index == word.length() - 1)
            return true;
        if (map.containsKey(word.charAt(index))) {
            return search(map.get(word.charAt(index)), word, index+1);
        } else
            return false;
    }
}
