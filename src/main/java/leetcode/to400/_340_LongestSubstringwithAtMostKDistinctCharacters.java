package leetcode.to400;

/**
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * Subject: Two Pointer
 * #Medium
 */
public class _340_LongestSubstringwithAtMostKDistinctCharacters {

    //Preferred solution.
    //Test case: "eceba", 2
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int res = 0, num = 0, j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(j++)] > 0) ;
                num--;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
