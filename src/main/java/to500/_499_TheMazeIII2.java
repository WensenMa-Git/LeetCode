package to500;

import java.util.PriorityQueue;


public class _499_TheMazeIII2 {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        String[] ori = new String[]{"d", "u", "r", "l"};

        boolean[][] visited = new boolean[maze.length][maze[0].length];

        Point point = new Point(ball[0], ball[1], 0, "");
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(point);

        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            if (cur.x == hole[0] && cur.y == hole[1]) {
                return cur.ori;
            }
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int newX = cur.x;
                int newY = cur.y;
                int dist = cur.dist;
                String curOri = cur.ori;

                while (isValid(maze, newX + directions[i][0], newY + directions[i][1])) {
                    if (newX == hole[0] && newY == hole[1]) {
                        break;
                    }
                    newX += directions[i][0];
                    newY += directions[i][1];
                    dist++;
                }
                if (!visited[newX][newY]) {
                    pq.offer(new Point(newX, newY, dist, curOri + ori[i]));
                }
            }
        }

        return "impossible";
    }

    private boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;
        String ori;

        Point(int x, int y, int dist, String ori) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.ori = ori;
        }

        public int compareTo(Point other) {
            return this.dist == other.dist ? this.ori.compareTo(other.ori) : this.dist - other.dist;
        }
    }
}
