package leetcode.toLast;

/**
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 * Subject: Greedy
 * #Hard #Google
 */
public class _1526_MinimumNumberOfIncrementsOnSubarrays {

    public int minNumberOperations(int[] target) {
        int res = target[0];
        for (int i = 1; i < target.length; i ++) {
            if (target[i] > target[i - 1]) {
                res += target[i] - target[i - 1];
            }
        }
        return res;
    }
}
