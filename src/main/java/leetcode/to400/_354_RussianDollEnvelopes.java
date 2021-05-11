package leetcode.to400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 * Subject: Array
 * Similar to find the longest increasing subsequence.
 * #Hard #Google
 */
public class _354_RussianDollEnvelopes {

    //Preferred solution.
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int i = binarySearch(dp, 0, res, envelope[1]);
            dp[i] = envelope[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[] dp, int start, int end, int target) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (dp[start] >= target) return start;
        return end;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        int res = 0;
        for (int[] envelope : envelopes) {
            int i = binarySearch2(dp, 0, res - 1, envelope[1]);
            dp[i] = envelope[1];
            if (i == res) {
                res++;
            }
        }
        return res;
    }

    private int binarySearch2(int[] dp, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] == target) {
                return mid;
            } else if (dp[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    //Provide a second solution.
    public int maxEnvelopes3(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0)
            return 0;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            else
                return a[0] - b[0];
        });


        // Longest Increasing Subsequence in O(nlogn) time
        int result = 0;
        List<Integer> piles = new ArrayList<>();
        for (int[] envelop : envelopes) {
            int height = envelop[1];
            int pile = Collections.binarySearch(piles, height);
            if (pile < 0) {
                pile = ~pile;
            }

            if (pile == piles.size()) {
                result++;
                piles.add(height);
            } else {
                piles.set(pile, height);
            }
        }

        return result;
    }
}
