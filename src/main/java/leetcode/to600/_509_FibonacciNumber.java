package leetcode.to600;


public class _509_FibonacciNumber {


    int[] fib = new int[31];

    public int fib(int N) {
        if (N <= 1) {
            return N;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        int a = 0, b = 1;
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public int fib4(int N) {
        if (N <= 1) {
            return N;
        }
        if (fib[N] != 0) {
            return fib[N];
        } else {
            return fib[N] = fib[N - 1] + fib[N - 2];
        }
    }
}
