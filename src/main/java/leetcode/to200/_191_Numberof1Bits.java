package leetcode.to200;

/**
 * https://leetcode.com/problems/number-of-1-bits/
 * Subject: Bit Math
 * #Easy
 */
public class _191_Numberof1Bits {

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res += n & 1;
            n >>= 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    //Provide a third solution (Preferred).
    public int hammingWeight3(int n) {
        int count=0;
        for(int i = 0; i < 32; i++){
            count += 1 & (n >>> i);
        }
        return count;
    }
}
