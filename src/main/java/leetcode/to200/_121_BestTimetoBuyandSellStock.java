package leetcode.to200;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Subject: Array
 * #Easy
 */
public class _121_BestTimetoBuyandSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int min = prices[0];
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    //Provide a second solution. (Preferred)
    public int maxProfit2(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return profit;
    }
}
