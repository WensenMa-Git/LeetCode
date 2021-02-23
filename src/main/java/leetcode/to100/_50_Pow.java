package leetcode.to100;

/**
 * https://leetcode.com/problems/powx-n/
 * Subject: Math
 * #Math
 */
public class _50_Pow {

    public static double myPow1(double x, int n) {
        if (n > 0) {
            return pow(x, n);
        } else {
            return 1.0 / pow(x, n);
        }
    }

    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = pow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    public static double myPow2(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        // int : -6.. ~ +6..  -2^32 ~ 2 ^32-1 Integer.MIN_VALUE
        long abs = Math.abs((long) n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }

    //Provide a third solution (Preferred)
    public double myPow3(double x, int n) {
        if (x == 0)
            return 0;
        if (n >= 0)
            return myF(x, n);
        else
            return 1.0 / myF(x, -n);
    }
    private double myF(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        double half = myF(x, n / 2);
        return n % 2 == 0 ? half * half : x * half * half;
    }
}
