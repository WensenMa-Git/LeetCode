package leetcode.to200;

/**
 * https://leetcode.com/problems/single-number-ii/
 * Subject: Bit
 * #Medium #Attention
 */
public class _137_SingleNumberII {

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    //Provide a second solution (Preferred)
    public int singleNumber2(int[] nums) {
        int result = 0;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for (int num : nums) {
                count += (num >>> i) & 1;
            }
            result |= (count % 3) << i;
        }
        return result;
    }
}
