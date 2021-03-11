package leetcode.to200;

/**
 * https://leetcode.com/problems/reverse-bits/
 * Subject: Bit Math
 * #Easy
 */
public class _190_ReverseBits {

    public int reverseBits(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            if ((n & 1) == 1) res++;
            n >>= 1;
        }
        return res;
    }

    //Provide a second solution (Preferred)
    public int reverseBits2(int n) {
        if (n == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (((n >>> i) & 1) << (31 - i));
        }
        return res;
    }
}
