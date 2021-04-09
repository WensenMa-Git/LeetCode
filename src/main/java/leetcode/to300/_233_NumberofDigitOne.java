package leetcode.to300;

/**
 * https://leetcode.com/problems/number-of-digit-one/
 * Subject: Math
 * #Hard #Attention
 */
public class _233_NumberofDigitOne {


    public int countDigitOne(int n) {
        int res = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            res += (a + 8) / 10 * m;
            if (a % 10 == 1) res += b + 1;
        }
        return res;
    }
}
