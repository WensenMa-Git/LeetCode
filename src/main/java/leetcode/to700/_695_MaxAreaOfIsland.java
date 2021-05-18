package leetcode.to700;

/**
 * https://leetcode.com/problems/max-area-of-island/
 * Subject: DFS
 * #Medium #Google
 */
public class _695_MaxAreaOfIsland {

    private int maxArea = 0;
    private int tempArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] != 0){
                    tempArea = 0;
                    getArea(grid, m, n, i, j);
                    maxArea = Math.max(maxArea, tempArea);
                }
            }
        }
        return maxArea;
    }

    private void getArea(int[][] grid, int m, int n, int i, int j){
        if(i < 0 || i >= m || j < 0 || j >=n || grid[i][j] == 0) return;
        tempArea++;
        grid[i][j] = 0;
        getArea(grid, m, n, i + 1, j);
        getArea(grid, m, n, i - 1, j);
        getArea(grid, m, n, i, j + 1);
        getArea(grid, m, n, i, j - 1);

    }

}
