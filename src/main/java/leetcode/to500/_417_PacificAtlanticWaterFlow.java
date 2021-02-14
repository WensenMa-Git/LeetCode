package leetcode.to500;

import java.util.ArrayList;
import java.util.List;


public class _417_PacificAtlanticWaterFlow {


    int m;
    int n;

    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        m = matrix.length;
        if (m == 0) return res;
        n = matrix[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            helper(matrix, pac, i, 0);
            helper(matrix, atl, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            helper(matrix, pac, 0, i);
            helper(matrix, atl, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }

        return res;
    }

    public void helper(int[][] matrix, boolean[][] isVisited, int i, int j) {
        isVisited[i][j] = true;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x < 0 || y < 0 || x >= m || y >= m || isVisited[x][y] || matrix[i][j] > matrix[x][y]) {
                continue;
            }
            helper(matrix, isVisited, x, y);
        }
    }
}
