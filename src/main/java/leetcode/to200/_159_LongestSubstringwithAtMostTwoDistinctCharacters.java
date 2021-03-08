package leetcode.to200;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * Subject: Two Pointer, Sliding Window
 * #Medium
 */
public class _159_LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int res = 0;
        while (end < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            if (map.size() > 2) {
                int leftMost = s.length();
                for (int num : map.values()) {
                    leftMost = Math.min(leftMost, num);
                }
                map.remove(s.charAt(leftMost));
                start = leftMost + 1;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }

    //Provide a second solution (Preferred)
    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        char[] sChars = s.toCharArray();
        int[] counts = new int[256];
        int len = 0;
        int count = 0;
        for (int L = 0, R = 0; R < sChars.length; R++) {
            if (counts[sChars[R]] == 0) {
                while (count == 2) {
                    if (--counts[sChars[L]] == 0) {
                        count--;
                    }
                    L++;
                }
                count++;
            }
            counts[sChars[R]]++;
            len = Math.max(len, R - L + 1);
        }
        return len;
    }

    //Provide a third solution
    public int lengthOfLongestSubstringTwoDistinct3(String s) {
        char[] sChars = s.toCharArray();
        int[] counts = new int[256];
        int len = 0;
        int count = 0;
        for (int L = 0, R = 0; R < sChars.length; R++) {
            if (counts[sChars[R]] == 0) {
                while (count == 2) {
                    if (--counts[sChars[L++]] == 0) {
                        count--;
                    }
                }
                count++;
            }
            counts[sChars[R]]++;
            len = Math.max(len, R - L + 1);
        }
        return len;
    }
}
