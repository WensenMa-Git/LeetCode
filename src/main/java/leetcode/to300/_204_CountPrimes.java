package leetcode.to300;

/**
 * https://leetcode.com/problems/count-primes/
 * Subject: Math
 * #Easy #Attention
 */
public class _204_CountPrimes {

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i]) {
                res++;
                for (int j = 2; i * j < n; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        return res;
    }
}
