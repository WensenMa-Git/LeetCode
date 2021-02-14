package leetcode.to300;


public class _231_PowerofTwo {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
