package to400;


public class _395_LongestSubstringwithAtLeastKRepeatingCharacters {


    // time : O(n) space : O(1)
    public int longestSubstring(String s, int k) {
        int res = 0;
        for (int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            res = Math.max(res, helper(s, k, numUniqueTarget));
        }
        return res;
    }

    private int helper(String s, int k, int numUniqueTareget) {
        int[] count = new int[128];
        int start = 0, end = 0;
        int numUnqiue = 0, numNoLessThanK = 0;
        int res = 0;

        while (end < s.length()) {
            if (count[s.charAt(end)]++ == 0) numUnqiue++;
            if (count[s.charAt(end++)] == k) numNoLessThanK++;

            while (numUnqiue > numUniqueTareget) {
                if (count[s.charAt(start)]-- == k) numNoLessThanK--;
                if (count[s.charAt(start++)] == 0) numUnqiue--;
            }
            if (numUnqiue == numUniqueTareget && numUnqiue == numNoLessThanK) {
                res = Math.max(end - start, res);
            }
        }
        return res;
    }
}
