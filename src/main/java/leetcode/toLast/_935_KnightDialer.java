package leetcode.toLast;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/knight-dialer/
 * Subject: Dynamic Programming
 * #Medium #hard #Google
 */
public class _935_KnightDialer {

    private static final int[][] prevCells = new int[][]{{4,6},
            {6,8},
            {7,9},
            {4,8},
            {3,9,0},
            {},
            {7,1,0},
            {6,2},
            {3,1},
            {2,4}};
    private static final int MOD_FACTOR = 1000000007;

    public int knightDialer(int n) {
        int[] curr = new int[10];
        Arrays.fill(curr, 1);
        int[] next = new int[10];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int prevCell : prevCells[j])
                    next[j] = (next[j] + curr[prevCell]) % MOD_FACTOR;
            }
            for (int j = 0; j <= 9; j++) {
                curr[j] = next[j];
                next[j] = 0;
            }
        }
        int result = 0;
        for (int i = 0; i <= 9; i++)
            result = (result + curr[i]) % MOD_FACTOR;
        return result;
    }

}
