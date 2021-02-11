package to500;


public class _486_PredicttheWinner {


    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }

    private int helper(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        } else {
            return Math.max(nums[start] - helper(nums, start + 1, end),
                    nums[end] - helper(nums, start, end - 1));
        }
    }

    public boolean PredictTheWinner2(int[] nums) {
        return helper2(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]) >= 0;
    }

    private int helper2(int[] nums, int start, int end, Integer[][] dp) {
        if (dp[start][end] == null) {
            if (start == end) {
                return nums[start];
            } else {
                return dp[start][end] = Math.max(nums[start] - helper2(nums, start + 1, end, dp),
                        nums[end] - helper2(nums, start, end - 1, dp));
            }
        }
        return dp[start][end];
    }

    public boolean PredictTheWinner3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][i] = nums[i];
                } else {
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }

    public boolean PredictTheWinner4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i] = nums[i];
                } else {
                    dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
                }
            }
        }
        return dp[n - 1] >= 0;
    }
}
