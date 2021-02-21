package leetcode.to100;

import java.util.Stack;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/
 * Subject: Two Pointer, Stack
 * #Hard
 */
public class _32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        res = Math.max(res, i - start);
                    } else {
                        res = Math.max(res, i - stack.peek());
                    }
                }
            }
        }
        return res;
    }
}



