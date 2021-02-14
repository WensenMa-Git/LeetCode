package leetcode.to600;


public class _562_LongestLineofConsecutiveOneinMatrix2 {


    public int longestLine2(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        int[][][] lengths = new int[m][n][4];
        int res = 0;
        int[][] directions = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 0) {
                    continue;
                }
                int k = 0;
                for (int[] direction : directions) {
                    int row = i + direction[0];
                    int col = j + direction[1];
                    lengths[i][j][k] = row >= 0 && col >= 0 && col < n ? lengths[row][col][k] + 1 : 1;
                    res = Math.max(res, lengths[i][j][k]);
                    k++;
                }
            }
        }
        return res;
    }
}
