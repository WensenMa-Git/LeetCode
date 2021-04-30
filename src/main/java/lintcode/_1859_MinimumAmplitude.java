package lintcode;

import java.util.Arrays;

/**
 * https://www.lintcode.com/problem/minimum-amplitude/
 * Subject: Sliding Window
 * #Easy
 */
public class _1859_MinimumAmplitude {

    public int MinimumAmplitude(int[] A) {
        // write your code here
        if (A.length < 4) return 0;
        Arrays.sort(A);
        int res = A[A.length - 1] - A[3];
        for (int i = 1; i <= 3; i++) {
            res = Math.min(A[A.length - 1 - i] - A[3 - i], res);
        }
        return res;
    }

}
