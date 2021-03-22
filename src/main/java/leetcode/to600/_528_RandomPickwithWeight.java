package leetcode.to600;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class _528_RandomPickwithWeight {

    Random rmd;
    int[] sum;

    public _528_RandomPickwithWeight(int[] w) {
        this.rmd = new Random();
        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }
        this.sum = w;
    }

    public int pickIndex() {
        int index = rmd.nextInt(sum[sum.length - 1]) + 1;
        int left = 0;
        int right = sum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sum[mid] == index) {
                return mid;
            } else if (sum[mid] < index) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    //Provide a second solution.
    //https://leetcode-cn.com/problems/random-pick-with-weight/solution/an-quan-zhong-sui-ji-xuan-ze-by-leetcode/
    class RandomPickWithWeight {

        List<Integer> psum = new ArrayList<>();
        int tot = 0;
        Random rand = new Random();

        public RandomPickWithWeight(int[] w) {
            for (int x : w) {
                tot += x;
                psum.add(tot);
            }
        }

        public int pickIndex() {
            int targ = rand.nextInt(tot);

            int lo = 0;
            int hi = psum.size() - 1;
            while (lo != hi) {
                int mid = (lo + hi) / 2;
                if (targ >= psum.get(mid)) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }
}
