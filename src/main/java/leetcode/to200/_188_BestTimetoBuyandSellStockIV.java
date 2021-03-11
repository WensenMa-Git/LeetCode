package leetcode.to200;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * Subject: Array
 * #Hard
 */
public class _188_BestTimetoBuyandSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return helper(prices);

        int[][] dp = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax = -prices[0];
            for (int j = 1; j < len; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tmpMax);
                tmpMax = Math.max(tmpMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][len - 1];
    }

    public int helper(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    //Provide a second solution (Preferred)
    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][0] = -prices[0];
        }
        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - price);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] + price);
            }
        }
        return dp[k][1];
    }
}
