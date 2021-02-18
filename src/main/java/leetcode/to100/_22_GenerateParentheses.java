package leetcode.to100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * Subject: Backtrack
 * #Medium
 */
public class _22_GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(res, "", n, n);
        return res;
    }

    public static void helper(List<String> res, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            helper(res, s + "(", left - 1, right);
        }
        if (right > 0) {
            helper(res, s + ")", left, right - 1);
        }
    }

    //Provide a second solution (Preferred)
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", res, n, 0, 0);
        return res;
    }

    public void backtrack(String cur, List<String> res, int n, int left, int right) {
        if (right == n) {
            res.add(cur);
            return;
        }
        if (left < n) {
            backtrack(cur + '(', res, n, left + 1, right);
        }
        if (left > right) {
            backtrack(cur + ')', res, n, left, right + 1);
        }
    }
}
