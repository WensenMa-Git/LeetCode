package to400;


public class _367_ValidPerfectSquare {


    // time : O(sqrt(n)) space : O(1)
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        if (num == 1) return true;
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) return true;
        }
        return false;
    }

    // time : O(logn) space : O(1)
    public boolean isPerfectSquare2(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }


    // time : O(n) space : O(1);
    public boolean isPerfectSquare3(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    // Newton Method time : 不知道 space : O(1);
    public boolean isPerfectSquare4(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}
