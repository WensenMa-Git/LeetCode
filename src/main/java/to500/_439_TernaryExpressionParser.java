package to500;

import java.util.Stack;


public class _439_TernaryExpressionParser {

    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '?') {
                stack.pop();
                char first = stack.pop();
                stack.pop();
                char second = stack.pop();
                if (c == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }

        return String.valueOf(stack.peek());
    }
}
