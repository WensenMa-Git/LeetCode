package leetcode.toLast;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * Subject: Sliding Window
 * #Medium #Google
 */
public class _1423_MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] ar, int k) {
        int takeLeft = 0;
        for (int i = 0; i < k; i++) {
            takeLeft += ar[i];
        }
        int takeRight = 0;

        int res = takeLeft + takeRight;
        for (int i = 0; i < k; i++) {
            takeRight += ar[ar.length - 1 - i];
            takeLeft -= ar[k - 1 - i];
            res = Math.max(res, takeLeft + takeRight);
        }
        return res;
    }
}
