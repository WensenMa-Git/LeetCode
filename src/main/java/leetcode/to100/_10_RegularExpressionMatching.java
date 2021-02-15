package leetcode.to100;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 * Subject: Dynamic Programming
 * #Hard #hard
 * Similar questions: 44. Wildcard Matching
 */
public class _10_RegularExpressionMatching {

    //Preferred solution.
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        System.out.println(Arrays.deepToString(dp));
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        //in this case, a* only counts as empty.
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        /*
                        for dp[i + 1][j], a* counts as a single a.
                        for dp[i][j + 1], a* counts as multiple a.
                        for dp[i + 1][j - 1], a* counts as empty.
                         */
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //Provide a second solution.
    public boolean isMatch2(String s, String p) {
        char[] input = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j<dp[0].length; j++) {
            if (pattern[j - 1] == '*')
                dp[0][j] = dp[0][j - 2];
        }
        for (int i = 1; i<dp.length; i++) {
            for (int j = 1; j<dp[0].length; j++) {
                if (input[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (pattern[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (pattern[j - 2] == '.' || input[i - 1] == pattern[j - 2]) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] arg) {
        System.out.println(new _10_RegularExpressionMatching().isMatch2("b", "a*b"));
    }
}