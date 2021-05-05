package leetcode.toLast;

public class _1277_CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <=m; i++) {
            for (int j = 1; j <=n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }
            }
        }
        return ans;
    }

    public int countSquares2(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int s=0;
        //first row
        for (int i=0;i<matrix.length;i++) {
            if(matrix[i][0]==1) {
                dp[i][0]=1;
                s += dp[i][0];
            }
        }
        //first column
        for (int j=1;j<matrix[0].length;j++) {
            if(matrix[0][j]==1) {
                dp[0][j]=1;
                s += dp[0][j];
            }
        }

        //count no of square matrixes
        for (int i=1;i<matrix.length;i++) {
            for (int j=1;j<matrix[0].length;j++) {
                if(matrix[i][j]==1) {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                    s += dp[i][j];
                }
            }
        }
        return s;
    }
}
