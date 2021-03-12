package leetcode.to300;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * Subject: Two Pointer
 * #Medium
 */
public class _209_MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (left <= i && sum >= s) {
                res = Math.min(res, i - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    //Provide a second solution (Preferred).
    public int minSubArrayLen2(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for (int L = 0, R = 0; R < nums.length; R++) {
            sum += nums[R];
            while(L <= R && sum >= target) {
                res = Math.min(res, R - L + 1);
                sum -= nums[L++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
