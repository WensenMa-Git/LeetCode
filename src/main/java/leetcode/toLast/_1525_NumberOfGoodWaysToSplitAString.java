package leetcode.toLast;

/**
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * Subject: String
 * #Medium #Google
 */
public class _1525_NumberOfGoodWaysToSplitAString {

    public int numSplits(String s) {
        int res = 0;
        int[] countLeft = new int[256];
        int[] countRight = new int[256];
        int left = 0;
        int right = 0;

        for (char cur : s.toCharArray()) {
            if (countRight[cur]++ == 0) {
                right++;
            }
        }
        for (char cur : s.toCharArray()) {
            if (countLeft[cur]++ == 0) {
                left++;
            }
            if (--countRight[cur] == 0) {
                right--;
            }
            if (left == right) res++;
        }

        return res;
    }
}
