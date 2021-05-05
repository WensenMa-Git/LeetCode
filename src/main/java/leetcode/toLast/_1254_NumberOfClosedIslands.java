package leetcode.toLast;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 * Subject: DFS
 * #Medium #Google
 */
public class _1254_NumberOfClosedIslands {

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    if(isClosedIsland(grid, i, j)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isClosedIsland(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }

        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean ans;

        ans = isClosedIsland(grid, i - 1, j) & isClosedIsland(grid, i, j - 1) & isClosedIsland(grid, i + 1, j) & isClosedIsland(grid, i, j + 1);

        return ans;
    }
}
