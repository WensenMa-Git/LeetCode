package leetcode.to200;

/**
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 * Subject: Math
 * #Easy #Attention
 */
public class _172_FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    //Provide a second solution (Preferred).
    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
