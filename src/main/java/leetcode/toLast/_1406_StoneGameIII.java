package leetcode.toLast;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/stone-game-iii/
 * Subject: Dynamic Programming
 * #Hard #Google
 */
public class _1406_StoneGameIII {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; //dp[i] means if i piles of stone has been taken, what is the max stone the person can take as next.
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;

        int[] values = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            values[i] += values[i + 1] + stoneValue[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <3; j++) {
                if (i + 1 + j > n) break;
                int pickValues = 0;
                for (int k = 0; k <= j; k++) {
                    pickValues += stoneValue[i + k];
                }
                dp[i] = Math.max(dp[i], pickValues + values[i + 1 + j] - dp[i + 1 + j]);
            }
        }

        if (dp[0] > values[0] - dp[0]) {
            return "Alice";
        } else if (dp[0] < values[0] - dp[0]) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    /*
    The idea is to use dynamic program strategy. Assume there are i stone has been removed, then dp[i] refers to the max value of the person could get.
     */

}
