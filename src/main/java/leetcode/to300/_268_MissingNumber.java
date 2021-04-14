package leetcode.to300;

/**
 * https://youtu.be/XtMThy8QKqU?t=1901
 * Subject: Array, Math
 * #Easy
 */
public class _268_MissingNumber {

    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }

    //Preferred solution.
    public int missingNumber2(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

}
