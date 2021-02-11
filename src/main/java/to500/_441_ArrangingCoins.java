package to500;


public class _441_ArrangingCoins {

    public int arrangeCoins(int n) {
        int i = 0;
        while (n > 0) {
            i += 1;
            n -= i;
        }
        return n == 0 ? i : i - 1;
    }

    public int arrangeCoins2(int n) {
        return (int) ((Math.sqrt(1 + 8 * (long) n) - 1) / 2);
    }
}
