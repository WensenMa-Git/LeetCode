package leetcode.to300;

/**
 * https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * Subject: Bit Math
 * #Medium
 */
public class _201_BitwiseANDofNumbersRange {

    //Preferred Solution.
    public int rangeBitwiseAnd(int m, int n) {
        int offset = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return m << offset;
    }

    //Provide a second solution.
    public int rangeBitwiseAnd2(int left, int right) {
        int offset = 0;
        while(left != right) {
            left >>>= 1;
            right >>>= 1;
            offset++;
        }
        return left << offset;
    }
}
