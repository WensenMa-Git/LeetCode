package leetcode.to300;

import java.util.Stack;

/**
 * https://leetcode.com/problems/basic-calculator/
 * Subject: Stack, Math
 * #Hard
 */
public class _224_BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += num * sign;
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                res = res * stack.pop() + stack.pop();
            }
        }
        return res;
    }

    class Solution {
        private int i = 0;

        public int calculate(String s) {
            if (s == null || s.length() == 0) return 0;
            i = 0;
            return calc(s + "+");
        }

        private int calc(String s) {
            int result = 0;
            int prev = 0;
            int num = 0;
            char sign = '+';
            for (; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') continue;
                if (c == '+' || c == '-' || c == ')') {
                    if (sign == '+') {
                        result += prev;
                        prev = num;
                    } else if (sign == '-') {
                        result += prev;
                        prev = -num;
                    }
                    if (c == ')') {
                        return result + prev;
                    }
                    sign = c;
                    num = 0;
                } else if (c == '(') {
                    i++;
                    num = calc(s);
                } else {
                    num = num * 10 + (int) (c - '0');
                }
            }
            return result + prev;
        }
    }
}


