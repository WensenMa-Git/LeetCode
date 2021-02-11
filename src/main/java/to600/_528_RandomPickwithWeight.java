package to600;

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
}
