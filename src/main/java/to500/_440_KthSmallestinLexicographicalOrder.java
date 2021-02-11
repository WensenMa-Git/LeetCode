package to500;


public class _440_KthSmallestinLexicographicalOrder {


    public static int findKthNumber(int n, int k) {
        int res = 1;
        k = k - 1;
        while (k > 0) {
            int steps = 0;
            long first = res, last = res + 1;
            while (first <= n) {
                steps += Math.min(n + 1, last) - first;
                first *= 10;
                last *= 10;
            }

            if (steps <= k) {
                res++;
                k -= steps;
            } else {
                res *= 10;
                k--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findKthNumber(13, 4);
    }
}
