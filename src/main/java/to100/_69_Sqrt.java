package to100;


public class _69_Sqrt {
    // 367	Valid Perfect Square


    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int low = 1, high = x;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        if (high * high < x) {
            return high;
        } else {
            return low;
        }
    }

    // Newton Method time : 不知道 space : O(1);
    public int mySqrt2(int x) {
        long res = x;
        while (res * res > x) {
            res = (res + x / res) / 2;
        }
        return (int) res;
    }
}
