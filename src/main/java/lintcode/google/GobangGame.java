package lintcode.google;

//Dynamic programming
public class GobangGame {
    public int longestLine2(int[][][] mat, int playerLength) {

        int m = mat.length;
        int n = mat[0].length;
        int[][][][] dp = new int[m + 1][n + 2][playerLength][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < playerLength; k++) {
                    if (mat[i][j][k] == 1) {
                        dp[i + 1][j + 1][k][0] = dp[i + 1][j][k][0] + 1;
                        dp[i + 1][j + 1][k][1] = dp[i][j + 1][k][1] + 1;
                        dp[i + 1][j + 1][k][2] = dp[i][j][k][2] + 1;
                        dp[i + 1][j + 1][k][3] = dp[i][j + 2][k][3] + 1;
                    }
                    for (int g = 0; g < 4; g++) {
                        if (dp[i + 1][j + 1][k][g] == 5) {
                            return g;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
