package to100;


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
}
