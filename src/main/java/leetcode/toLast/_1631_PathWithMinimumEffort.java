package leetcode.toLast;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 * Subject: Binary Search
 * #Medium #Google
 */
public class _1631_PathWithMinimumEffort {

    //Binary Search + BFS
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int minimumEffortPath(int[][] heights) {
        int left = 0, right = 1000000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isOK(heights, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isOK(int[][] heights, int effort) {
        int m = heights.length;
        int n = heights[0].length;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int i = cur[0] + dir[k][0];
                int j = cur[1] + dir[k][1];

                if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) continue;
                if (Math.abs(heights[i][j] - heights[cur[0]][cur[1]]) > effort) continue;
                visited[i][j] = true;
                queue.add(new int[]{i, j});
            }
        }
        return visited[m - 1][n - 1];
    }
}
