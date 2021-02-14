package leetcode.to500;

import java.util.HashMap;


public class _446_ArithmeticSlicesIISubsequence {


    public static int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        long res = 0;
        HashMap<Integer, Integer>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long delta = (long) A[i] - (long) A[j];
                if (delta < Integer.MIN_VALUE || delta > Integer.MAX_VALUE) {
                    continue;
                }
                int diff = (int) delta;
                int sum = map[j].getOrDefault(diff, 0);
                int origin = map[i].getOrDefault(diff, 0);
                map[i].put(diff, origin + sum + 1);
                res += sum;
            }
        }
        return (int) res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 6, 8, 10};
        numberOfArithmeticSlices(nums);
    }
}
