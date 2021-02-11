package to500;

import java.util.HashSet;


public class _489_RobotRoomCleaner {


    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void cleanRoom(Robot robot) {
        backtracking(robot, 0, 0, 0, new HashSet<>());
    }

    public void backtracking(Robot robot, int x, int y, int curDir, HashSet<String> visited) {
        visited.add(x + "-" + y);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4;
            int newX = x + dirs[nextDir][0];
            int newY = y + dirs[nextDir][1];
            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                backtracking(robot, newX, newY, nextDir, visited);
            }
            robot.turnRight();
        }
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();

        void turnRight();

        // Clean the current cell.
        void clean();
    }
}
