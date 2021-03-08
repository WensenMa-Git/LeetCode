package leetcode.to200;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 * Subject: Array, Dynamic Programming
 * #Medium
 */
public class _152_MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], temp * nums[i]), nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int tempMax = nums[0];
        int tempMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = tempMax, mn = tempMin;
            tempMax = Math.max(nums[i], Math.max(mx * nums[i], mn * nums[i]));
            tempMin = Math.min(nums[i], Math.min(mx * nums[i], mn * nums[i]));
            max = Math.max(max, tempMax);
        }
        return max;
    }
}
