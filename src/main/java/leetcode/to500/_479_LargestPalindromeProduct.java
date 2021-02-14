package leetcode.to500;


public class _479_LargestPalindromeProduct {


    public int largestPalindrome(int n) {
        long max = (long) Math.pow(10, n) - 1;
        long min = max / 10;
        for (long left = max; left > min; left--) {
            long right = Long.parseLong(new StringBuilder("" + left).reverse().toString());
            long target = left * (max + 1) + right;
            for (long i = max; i * i >= target; i--) {
                if (target % i == 0) {
                    return (int) (target % 1337);
                }
            }
        }
        return 9;
    }
}
