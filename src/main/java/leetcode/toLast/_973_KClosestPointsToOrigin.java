package leetcode.toLast;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * Subject: Array
 * #Medium
 */
public class _973_KClosestPointsToOrigin {

    class Data {
        private int distance;
        private int pointX;
        private int pointY;
        public Data(int distance, int pointX, int pointY) {
            this.distance = distance;
            this.pointX = pointX;
            this.pointY = pointY;
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Data> queue = new PriorityQueue<Data>((d1, d2) -> (int) (d2.distance - d1.distance));

        for(int i = 0 ; i < points.length; i++) {
            int distance =  points[i][0]*points[i][0] + points[i][1] * points[i][1];
            Data data = new Data(distance, points[i][0], points[i][1]);
            queue.add(data);
            if(queue.size() > K) {
                queue.poll();
            }
        }

        int[][] result = new int[K][2];

        int  i = 0;
        while (!queue.isEmpty()) {
            Data data = queue.poll();
            result[i][0] = data.pointX;
            result[i][1] = data.pointY;
            i++;
        }
        return result;
    }
}
