package leetcode.to600;

/**
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/
 * Subject: Dynamic Programming
 * #Medium #Google
 */
public class _562_LongestLineofConsecutiveOneinMatrix {

    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[] col = new int[M[0].length];
        int[] antiD = new int[M.length + M[0].length];
        int[] diag = new int[M.length + M[0].length];
        for (int i = 0; i < M.length; i++) {
            int row = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    row++;
                    col[j]++;
                    antiD[i + j]++;
                    diag[j - i + M.length]++;
                    res = Math.max(res, row);
                    res = Math.max(res, col[j]);
                    res = Math.max(res, antiD[i + j]);
                    res = Math.max(res, diag[j - i + M.length]);
                } else {
                    row = 0;
                    col[j] = 0;
                    antiD[i + j] = 0;
                    diag[j - i + M.length] = 0;
                }
            }
        }
        return res;
    }

    //Provide a second solution. (Preferred)
    public int longestLine2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][][] dp = new int[m + 1][n + 2][4];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    dp[i + 1][j + 1][0] = dp[i + 1][j][0] + 1;
                    dp[i + 1][j + 1][1] = dp[i][j + 1][1] + 1;
                    dp[i + 1][j + 1][2] = dp[i][j][2] + 1;
                    dp[i + 1][j + 1][3] = dp[i][j + 2][3] + 1;
                    for (int k = 0; k < 4; k++) {
                        res = Math.max(res, dp[i + 1][j + 1][k]);
                    }
                }
            }
        }
        return res;
    }
}
