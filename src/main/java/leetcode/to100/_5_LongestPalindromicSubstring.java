package leetcode.to100;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Subject: String, Two Pointer
 * #Medium
 */
public class _5_LongestPalindromicSubstring {

    String res = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    //Provide a second solution (Preferred)
    // time : O(n^2) space : O(1)
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return s;
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return res;
    }

    public void helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }

    //Provide a third solution.
    public String longestPalindrome3(String s) {
        if(s.length() == 0) return "";
        char[] sChars = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i = 0; i < sChars.length; i++){
            int len1 = getLen(sChars, i, i);
            int len2 = getLen(sChars, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int getLen(char[] sChars, int left, int right){
        while(left >= 0 && right < sChars.length && sChars[left] == sChars[right]){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
