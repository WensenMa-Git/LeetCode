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

    //Provide a second solution.
    //leetcode-cn.com/problems/knight-dialer/solution/dpji-yi-hua-di-gui-by-8bun/
    //行下标为起点num,每一行的所有数据为可达数字

    /**
     * 每个数字及可达数字为：
     * 0 -> 4, 6
     * 1 -> 6, 8
     * 2 -> 7, 9
     * 3 -> 4, 8
     * 4 -> 3, 9, 0
     * 5 ->
     * 6 -> 1, 7, 0
     * 7 -> 2, 6
     * 8 -> 1, 3
     * 9 -> 4, 2
     *  设dp[time][num] 表示骑士第time次跳到数字num时组成的不同号码的个数
     *  那么要实现第time次跳到数字num,那么就要保证第time-1次跳到num的可达数字
     *  也就是说dp[time][num]是第time-1跳到num的所有可达数字的dp的总和
     *  最后返回要求dp[N-1][]的值
     */

    private int[][] path = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {4, 2}};
    private static final int MOD = 1000000007;

    public int knightDialer2(int N) {
        int[][] dp = new int[N][10];
        for (int num = 0; num < 10; num++)
            dp[0][num] = 1; //第0次（跳到）num的不同号码个数为1

        for (int time = 1; time < N; time++) {
            for (int num = 0; num < 10; num++){
                for (int arrive : path[num])
                    dp[time][num] = (dp[time][num] + dp[time - 1][arrive]) % MOD;
            }
        }
        int res = 0;
        for (int num = 0; num < 10; num++)
            res = (res + dp[N - 1][num]) % MOD;
        return res;
    }

}
