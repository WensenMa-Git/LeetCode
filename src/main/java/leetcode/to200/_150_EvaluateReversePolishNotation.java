package leetcode.to200;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * Subject: Stack
 * #Medium
 */
public class _150_EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    //Provide a second solution (Preferred)
    public int evalRPN2(String[] tokens) {
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> numbers = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int y = numbers.pop();
                int x = numbers.pop();
                numbers.push(eval(token, x, y));
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.pop();
    }

    private int eval(String operator, int x, int y) {
        switch (operator) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                return x / y;
        }
    }
}
