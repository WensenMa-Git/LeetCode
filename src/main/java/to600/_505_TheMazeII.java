package to600;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class _505_TheMazeII {

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] dists = new int[maze.length][maze[0].length];
        for (int[] dist : dists) {
            Arrays.fill(dist, -1);
        }
        dists[start[0]][start[1]] = 0;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(start[0], start[1]));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int[] direction : directions) {
                int newX = cur.x;
                int newY = cur.y;
                int dist = dists[newX][newY];
                while (isValid(maze, newX + direction[0], newY + direction[1])) {
                    newX += direction[0];
                    newY += direction[1];
                    dist++;
                }
                if (dists[newX][newY] == -1 || dist < dists[newX][newY]) {
                    queue.offer(new Point(newX, newY));
                    dists[newX][newY] = dist;
                }
            }
        }
        return dists[destination[0]][destination[1]];
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
