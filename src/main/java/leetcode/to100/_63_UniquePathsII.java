package leetcode.to100;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 * Subject: Dynamic Programming
 * #Medium
 */
public class _63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid[0].length;
        int[] res = new int[length];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else if (j > 0) {
                    res[j] += res[j - 1];
                }
            }
        }
        return res[length - 1];
    }

    //Provide a second solution (Preferred)
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) return 0;
        int n = obstacleGrid[0].length;
        int[][] mat = new int[m + 1][n + 1];
        mat[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                mat[i][j] = (obstacleGrid[i][j] == 1) ? 0 : mat[i + 1][j] + mat[i][j + 1];
            }
        }
        return mat[0][0];
    }
}
