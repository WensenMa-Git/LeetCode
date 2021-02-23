package leetcode.to100;

/**
 * https://leetcode.com/problems/jump-game/
 * Subject: Dynamic Programming
 * #Medium
 */
public class _55_JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }

    //Provide a second solution (Preferred)
    public boolean canJump2(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; i++) {
            reach = Math.max(i + nums[i], reach);
        }
        return i == nums.length;
    }
}