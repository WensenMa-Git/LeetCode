package leetcode.to400;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * Subject: Backtrack
 * #Hard #Attention
 */
public class _301_RemoveInvalidParentheses {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }

    public void helper(List<String> res, String s, int last_i, int last_j, char[] pair) {
        for (int count = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            helper(res, reversed, 0, 0, new char[]{')', '('});
        } else {
            res.add(reversed);
        }
    }

    //Provide a second solution. (Preferred)
    //https://www.youtube.com/watch?v=lEMDEmQje1Q&t=0s
    //()))(((
    public List<String> removeInvalidParentheses2(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, 0, res, new char[]{'(', ')'});
        return res;
    }

    private void backtrack(String s, int left, int right, List<String> res, char[] pairs) {
        int stack = 0;
        int n = s.length();
        for (; right < n; right++) {
            char c = s.charAt(right);
            if (c == pairs[0]) {
                stack++;
            } else if (c == pairs[1]) {
                stack--;
            }
            if (stack < 0) break;
        }
        if (stack < 0) {
            for (; left <= right; left++) {
                char c = s.charAt(left);
                if (c != pairs[1]) continue;
                if (left > 1 && s.charAt(left) == s.charAt(left - 1)) continue;
                backtrack(s.substring(0, left) + s.substring(left + 1), left, right, res, pairs);
            }
        } else if (stack > 0) {
            backtrack(new StringBuilder(s).reverse().toString(), 0, 0, res, new char[]{')', '('});
        } else {
            res.add(pairs[0] == '(' ? s : new StringBuilder(s).reverse().toString());
        }
    }
}
