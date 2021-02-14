package leetcode.to600;


public class _576_OutofBoundaryPaths {


    public static int findPaths(int m, int n, int N, int i, int j) {
        if (N <= 0) {
            return 0;
        }

        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int[] dir : dirs) {
                        int newR = r + dir[0];
                        int newC = c + dir[1];
                        if (newR < 0 || newR >= m || newC < 0 || newC >= n) {
                            res = (res + dp[r][c]) % MOD;
                        } else {
                            temp[newR][newC] = (temp[newR][newC] + dp[r][c]) % MOD;
                        }
                    }
                }
            }
            dp = temp;
        }

        return res;
    }
}
