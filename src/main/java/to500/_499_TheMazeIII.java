package to500;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class _499_TheMazeIII {


    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        String[] ori = new String[]{"d", "u", "r", "l"};

        int[][] dists = new int[maze.length][maze[0].length];
        for (int[] dist : dists) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        dists[ball[0]][ball[1]] = 0;

        String[][] res = new String[maze.length][maze[0].length];
        for (String[] s : res) {
            Arrays.fill(s, "impossible");
        }
        res[ball[0]][ball[1]] = "";

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(ball[0], ball[1]));

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.x;
                int newY = cur.y;
                int dist = dists[newX][newY];
                String curOri = res[newX][newY];
                curOri += ori[i];

                while (isValid(maze, newX + directions[i][0], newY + directions[i][1])) {
                    if (newX == hole[0] && newY == hole[1]) {
                        break;
                    }
                    newX += directions[i][0];
                    newY += directions[i][1];
                    dist++;
                }
                if (newX == cur.x && newY == cur.y) {
                    continue;
                }
                if (dist <= dists[newX][newY]) {
                    if (dist < dists[newX][newY]) {
                        dists[newX][newY] = dist;
                        res[newX][newY] = curOri;
                    } else if (curOri.compareTo(res[newX][newY]) < 0) {
                        res[newX][newY] = curOri;
                    }
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        return res[hole[0]][hole[1]];
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
