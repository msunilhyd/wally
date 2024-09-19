package com.sunil;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        // 1. Declare a stack to store the parenthesis
        Stack<Character> stack = new Stack<>();
        // 2. Traverse the string
        for (char c : s.toCharArray()) {
            // 2.1 If the character is a left parenthesis, (, {, [ push to the stack
            if (c == '(')
                stack.push(')');
            if (c == '{')
                stack.push('}');
            if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}
