package to600;

import java.util.HashMap;
import java.util.Random;


public class _519_RandomFlipMatrix {


    HashMap<Integer, Integer> map;
    int m, n;
    int total;
    Random random;

    public _519_RandomFlipMatrix(int n_rows, int n_cols) {
        map = new HashMap<>();
        random = new Random();
        m = n_rows;
        n = n_cols;
        reset();
    }

    public int[] flip() {
        int rand = random.nextInt(total--);
        int res = map.getOrDefault(rand, rand);
        map.put(rand, map.getOrDefault(total, total));
        map.put(total, res);
        return new int[]{res / n, res % n};
    }

    public void reset() {
        total = m * n;
    }
}
