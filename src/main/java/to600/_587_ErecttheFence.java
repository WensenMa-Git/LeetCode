package to600;

import java.util.*;


public class _587_ErecttheFence {


    public List<Point> outerTrees(Point[] points) {
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x - o2.x == 0 ? o1.y - o2.y : o1.x - o2.x;
            }
        });
        Stack<Point> stack = new Stack<>();
        for (int i = 0; i < points.length; i++) {
            while (stack.size() >= 2 && orientation(points[i],
                    stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }
        stack.pop();
        for (int i = points.length - 1; i >= 0; i--) {
            while (stack.size() >= 2 && orientation(points[i],
                    stack.get(stack.size() - 2), stack.get(stack.size() - 1)) > 0) {
                stack.pop();
            }
            stack.push(points[i]);
        }
        return new ArrayList<>(new HashSet<>(stack));
    }

    private int orientation(Point p1, Point p2, Point p3) {
        return (p3.x - p2.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p3.y - p2.y);
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
