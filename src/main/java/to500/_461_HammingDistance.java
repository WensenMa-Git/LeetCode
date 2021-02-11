package to500;


public class _461_HammingDistance {


    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int res = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            res++;
        }
        return res;
    }
}
