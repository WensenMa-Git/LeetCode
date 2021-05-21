package leetcode.toLast;

/**
 * https://leetcode.com/problems/stone-game-ii/
 * Subject: Recurse, Dynamic programming
 * #Medium #Google
 */
public class _1140_StoneGameII {

    int[][] dp = new int[1000][1000];
    int[] rest = null;
    public int stoneGameII(int[] piles) {
        rest = new int[piles.length + 1];
        for (int i = piles.length - 1; i >= 0; i--) {
            rest[i] = rest[i + 1] + piles[i];
        }
        return solve(0, 1, piles);
    }

    private int solve(int index, int M, int[] piles) {
        if (index == piles.length) return 0;
        if (dp[index][M] != 0) return dp[index][M];
        int tempsum = 0;
        for (int i = 1; i <= 2 * M; i++) {
            if (index + i - 1>= piles.length) {
                break;
            }
            tempsum += piles[index + i - 1];
            dp[index][M] = Math.max(dp[index][M], tempsum + rest[index + i] - solve(index + i, Math.max(i, M), piles));
        }
        return dp[index][M];
    }
}
