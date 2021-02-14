package leetcode.to600;


public class _600_NonnegativeIntegerswithoutConsecutiveOnes {


    public static int findIntegers(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int res = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') {
                break;
            }
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') {
                res -= b[i];
            }
        }

        return res;
    }

    public static int findIntegers2(int num) {
        int[] fn = new int[32];
        fn[0] = 1;
        fn[1] = 2;
        for (int i = 2; i < fn.length; i++) {
            fn[i] = fn[i - 1] + fn[i - 2];
        }

        char[] binChr = Integer.toBinaryString(num).toCharArray();
        int len = binChr.length - 1;
        int res = 0;
        boolean preBit = false;
        for (int i = 0; i < binChr.length; i++) {
            if (binChr[i] == '1') {
                res += fn[len - i];
                if (preBit) {
                    return res;
                }
                preBit = true;
            } else {
                preBit = false;
            }
        }

        return res + 1;
    }

    public static void main(String[] args) {
        findIntegers2(5);
    }

}
