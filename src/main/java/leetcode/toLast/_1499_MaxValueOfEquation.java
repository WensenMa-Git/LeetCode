package leetcode.toLast;

/**
 * https://leetcode.com/problems/max-value-of-equation/
 * Subject: Two Pointer, Sliding Window
 * #Hard #Attetion #Google
 */
public class _1499_MaxValueOfEquation {

    public int findMaxValueOfEquation(int[][] points, int k) {

        int res = Integer.MIN_VALUE;
        int m = points.length;
        for (int left = 0, right = 1; right < m; right++) {
            while (points[right][0] - points[left][0] > k) {
                left++;
            }
            if (left == right) continue;


            res = Math.max(res, points[right][0] - points[left][0] + points[right][1] + points[left][1]);

            if (points[right][1] - points[right][0] > points[left][1] - points[left][0]) {
                left++;
                right--;
            }
        }
        return res;
    }
}
