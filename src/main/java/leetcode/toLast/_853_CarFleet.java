package leetcode.toLast;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/car-fleet/
 * Subject: Array
 * #Medium #Google
 */
public class _853_CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (o1, o2) -> o2[0] - o1[0]);

        double[] arriveTimes = new double[position.length];
        for (int i = 0; i < arriveTimes.length; i++) {
            arriveTimes[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        double min = 0.0;
        int res = 0;
        for (double arriveTime : arriveTimes) {
            if (arriveTime > min) {
                min = arriveTime;
                res++;
            }
        }
        return res;
    }

}
