package leetcode.to600;

import java.util.Arrays;


public class _568_MaximumVacationDays {


    public static int maxVacationDays(int[][] flights, int[][] days) {
        int N = flights.length;  // city
        int K = days[0].length;  // week
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 0; i < K; i++) {
            int[] temp = new int[N];
            Arrays.fill(temp, Integer.MIN_VALUE);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (j == k || flights[k][j] == 1) {
                        temp[j] = Math.max(temp[j], dp[k] + days[j][i]);
                    }
                }
            }
            dp = temp;
        }

        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] flights = new int[][]{
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 0}
        };
        int[][] days = new int[][]{
                {1, 3, 1},
                {6, 0, 3},
                {3, 3, 3}
        };
        maxVacationDays(flights, days);
    }
}
