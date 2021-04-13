package leetcode.to300;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/
 * Subject: Array
 * #Medium
 */
public class _259_ThreeSumSmaller {

    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    res += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }

    //Provide a second solution. (Preferred)
    public int threeSumSmaller2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;
        for (int i = 0; i < n; i++) {
            int lo = i+1, hi = n-1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum < target) {
                    count += hi - lo;
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return count;
    }
}
