package leetcode.to300;

/**
 * https://leetcode.com/problems/power-of-two/
 * Subject: Math
 * #Easy
 */
public class _231_PowerofTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }

    //Provide a second solution (Preferred)
    public boolean isPowerOfTwo2(int n) {
        while (n > 0) {
            if (n == 1) return true;
            if (n%2 != 0) return false;
            n/=2;
        }
        return false;
    }
}
