package to600;

import java.util.ArrayList;
import java.util.List;


public class _564_FindtheClosestPalindrome {


    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean isEven = (len % 2 == 0);
        int mid = isEven ? len / 2 - 1 : len / 2;
        long left = Long.parseLong(n.substring(0, mid + 1));

        List<Long> candidate = new ArrayList<>();
        candidate.add(getPalindrome(left, isEven));
        candidate.add(getPalindrome(left + 1, isEven));
        candidate.add(getPalindrome(left - 1, isEven));
        candidate.add((long) Math.pow(10, len - 1) - 1);
        candidate.add((long) Math.pow(10, len) + 1);

        long diff = Long.MAX_VALUE;
        long res = 0;
        long num = Long.parseLong(n);
        for (long cand : candidate) {
            if (cand == num) continue;
            if (Math.abs(cand - num) < diff) {
                diff = Math.abs(cand - num);
                res = cand;
            } else if (Math.abs(cand - num) == diff) {
                res = Math.min(res, cand);
            }
        }

        return String.valueOf(res);
    }

    private long getPalindrome(long left, boolean even) {
        long res = left;
        if (!even) {
            left = left / 10;
        }
        while (left > 0) {
            res = res * 10 + left % 10;
            left /= 10;
        }
        return res;
    }
}
