package leetcode.to300;

/**
 * https://leetcode.com/problems/house-robber-ii/
 * Subject: Dynamic Programming
 * #Medium
 */
public class _213_HouseRobberII {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int lo, int hi) {
        int prevNo = 0;
        int prevYes = 0;
        for (int i = lo; i <= hi; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = nums[i] + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
