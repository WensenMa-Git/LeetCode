package leetcode.to600;


public class _514_FreedomTrail {


    public int findRotateSteps(String ring, String key) {
        return helper(ring, key, 0, 0, new int[ring.length()][key.length()]);
    }

    private int helper(String ring, String target, int ringIndex, int targetIndex, int[][] memo) {
        if (targetIndex == target.length()) {
            return 0;
        }

        if (memo[ringIndex][targetIndex] != 0) {
            return memo[ringIndex][targetIndex];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); i++) {
            if (ring.charAt(i) != target.charAt(targetIndex)) {
                continue;
            }
            int diff = Math.abs(i - ringIndex);
            int distance = 1 + Math.min(diff, ring.length() - diff)
                    + helper(ring, target, i, targetIndex + 1, memo);
            min = Math.min(min, distance);
        }
        memo[ringIndex][targetIndex] = min;
        return min;
    }


    public int findRotateSteps2(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m + 1][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, n - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }

        return dp[0][0] + m;
    }
}
