package leetcode.toLast;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/max-value-of-equation/
 * Subject: Two Pointer, Sliding Window
 * #Hard #Attetion #Google
 */
public class _1499_MaxValueOfEquation {

    public int findMaxValueOfEquation2(int[][] points, int k) {

        int res = Integer.MIN_VALUE;
        int m = points.length;
        //y3 + y1 + x3 -x1 < y3 + y2 + x3 - x2 --> y2 - y1 > x2 - x1
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o2[0] - (o1[1] - o1[0]);
        });

        queue.add(points[0]);

        for (int left = 0, right = 1; right < m; right++) {
            while (points[right][0] - points[left][0] > k) {
                queue.remove(points[left]);
                left++;
            }
            if (left != right) {

                int[] peek = queue.peek();
                res = Math.max(res, points[right][0] - peek[0] + points[right][1] + peek[1]);
            }
            queue.add(points[right]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        System.out.println(new _1499_MaxValueOfEquation().findMaxValueOfEquation2(points, 1));
    }
}
