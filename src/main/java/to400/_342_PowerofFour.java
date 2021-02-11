package to400;


public class _342_PowerofFour {


    // time : < O(n)
    public boolean isPowerOfFour(int n) {
        if (n > 1) {
            while (n % 4 == 0) {
                n /= 4;
            }
        }
        return n == 1;
    }

    // time : O(1)
    public boolean isPowerOfFour2(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }
}
