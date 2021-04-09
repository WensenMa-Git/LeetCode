package leetcode.to800;

/**
 * https://leetcode.com/problems/basic-calculator-iii/
 * Subject: String, Stack
 * #Hard
 */
public class _772_BasicCalculatorIII {

    public int calculate(String s) {
        return helper(s + "+", new int[1]);
    }

    private int helper(String s, int[] pos) {
        int val = 0, prev = 0, ret = 0;
        char sign = '+';
        while (pos[0] < s.length()) {
            char c = s.charAt(pos[0]++);

            if (c == ' ') {
                continue;
            }

            if (c == '(') {
                val = helper(s, pos);
            } else if (Character.isDigit(c)) {
                val = 10 * val + c - '0';
            } else {
                if (sign == '+') {
                    ret += prev;
                    prev = val;
                } else if (sign == '-') {
                    ret += prev;
                    prev = -val;
                } else if (sign == '*') {
                    prev *= val;
                } else {
                    prev /= val;
                }
                if (c == ')')
                    break;
                sign = c;
                val = 0;
            }
        }
        return ret + prev;
    }

}
