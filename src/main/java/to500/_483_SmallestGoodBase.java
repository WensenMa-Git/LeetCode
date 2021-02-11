package to500;


public class _483_SmallestGoodBase {


    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);

        for (int m = (int) (Math.log(num + 1) / Math.log(2)); m > 2; m--) {
            long l = 2;
            long r = (long) (Math.pow(num, 1.0 / (m - 1)));
            while (l <= r) {
                long k = l + (r - l) / 2;
                long sum = 0, cur = 1;
                for (int i = 0; i < m; i++) {
                    sum += cur;
                    cur *= k;
                }
                if (num == sum) {
                    return String.valueOf(k);
                } else if (num < sum) {
                    r = k - 1;
                } else {
                    l = k + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}
