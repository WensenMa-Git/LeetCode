package leetcode.to300;

/**
 * https://leetcode.com/problems/paint-house-ii/
 * Subject: Dynamic Programming
 * #Hard #Attention
 */
public class _265_PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length;
        int k = costs[0].length;

        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1;
            min2 = -1;
            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1;
                    min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }
        return costs[n - 1][min1];
    }

    //Provide a second solution. (Preferred)
    public int minCostII2(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int min1 = 0, min2 = 0, minIndex = -1;
        for (int[] ints : costs) {
            int curMin1 = Integer.MAX_VALUE, curMin2 = Integer.MAX_VALUE, curMinIndex = 0;
            for (int j = 0; j < k; j++) {
                int cost = ints[j] + (j == minIndex ? min2 : min1);
                if (cost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = cost;
                    curMinIndex = j;
                } else if (cost < curMin2) {
                    curMin2 = cost;
                }
            }
            min1 = curMin1;
            min2 = curMin2;
            minIndex = curMinIndex;
        }
        return min1;
    }
}
