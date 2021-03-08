package leetcode.to200;

import leetcode.dependency.Point;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class _149_MaxPointsonaLine {

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length < 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameXAxis = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        samePoint++;
                    }
                    if (points[i].x == points[j].x) {
                        sameXAxis++;
                        continue;
                    }
                    int numerator = points[i].y - points[j].y;
                    int denominator = points[i].x - points[j].x;
                    int gcd = gcd(numerator, denominator);
                    String hashStr = (numerator / gcd) + "/" + (denominator / gcd);
                    map.put(hashStr, map.getOrDefault(hashStr, 1) + 1);
                    res = Math.max(res, map.get(hashStr) + samePoint);
                }
            }
            res = Math.max(res, sameXAxis);
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
