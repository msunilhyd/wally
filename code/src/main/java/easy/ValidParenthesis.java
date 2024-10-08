package easy;

import java.util.ArrayDeque;
import java.util.Deque;
// 6
public class ValidParenthesis {

    public static void main(String[] args) {
        String str = "(([]})";
        System.out.println(isValid(str));
    }

    private static final String OPEN_BRACKETS = "({[";
    private static final String CLOSE_BRACKETS = ")}]";

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (OPEN_BRACKETS.indexOf(c) != -1) {
                stack.push(c);
            } else {
                if (CLOSE_BRACKETS.indexOf(c) != OPEN_BRACKETS.indexOf(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
