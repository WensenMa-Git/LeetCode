package leetcode.toLast;

/**
 * https://leetcode.com/problems/new-21-game/
 * Subject: Dynamic Programming
 * #Medium #hard #Attention #Google
 */
public class _837_New21Game {

    //Too Slow
    public double new21Game(int N, int K, int W) {
        return dfs(0, N, K, W);
    }

    private double dfs(int cur, int N, int K, int W) {
        if (cur >= K) {
            if (cur <= N) {
                return 1;
            } else {
                return 0;
            }
        }
        double sum = 0;
        for (int i = 1; i <= W; i++) {
            sum += 1.0 / W * dfs(cur + i, N, K, W);
        }
        return sum;
    }

    //Preferred Solution.
    public double new21Game2(int N, int K, int W) {
        if (K == 0) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        double slidingSum = 0.0;
        for (int i = K; i < K + W; i++) {
            if (i <= N) {
                dp[i] = 1.0;
            } else {
                dp[i] = 0.0;
            }
            slidingSum += dp[i];
        }
        // System.out.println(slidingSum);
        dp[K - 1] = slidingSum / W;
        for (int i = K - 2; i >= 0; i--) {
            slidingSum = slidingSum + dp[i + 1] - dp[i + 1 + W];
            dp[i] = slidingSum / W;
        }
        return dp[0];
    }
}
