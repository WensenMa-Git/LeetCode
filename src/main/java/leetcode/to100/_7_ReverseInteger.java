package leetcode.to100;

/**
 * https://leetcode.com/problems/reverse-integer/
 * Subject: Math
 * #Easy
 */
public class _7_ReverseInteger {

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int) res;
    }

    public static int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int cur = res;
            res = res * 10 + x % 10;
            if (res / 10 != cur) return 0;
            x = x / 10;
        }
        return res;
    }

    //Provide a third solution.
    public int reverse3(int x) {
        int num = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            if (Math.abs(num) > 214748364) return 0;
            num = num * 10 + digit;
        }
        return num;
    }

    //Provide a fourth solution (Preferred)
    public int reverse4(int x) {
        int num = 0;
        while (x != 0) {
            if (Math.abs(num) > 214748364) return 0;
            num = num * 10 + x % 10;
            x /= 10;
        }
        return num;
    }
}
