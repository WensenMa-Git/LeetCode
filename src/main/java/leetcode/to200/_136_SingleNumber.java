package leetcode.to200;

/**
 * https://leetcode.com/problems/single-number/
 * Subject: Bit
 * #Easy
 */
public class _136_SingleNumber {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
