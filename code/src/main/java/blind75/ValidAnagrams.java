package blind75;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagrams {

    public static void main(String[] args) {
        System.out.println(validAnagrams("sunil", "links"));
    }

    public static boolean validAnagrams(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            else
                map.put(s.charAt(i), 1);
        }

        for (int i=0; i<t.length(); i++) {
            if (!map.containsKey(t.charAt(i)))
                return false;
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() != 0)
                return false;
        }
        return true;
    }
}
