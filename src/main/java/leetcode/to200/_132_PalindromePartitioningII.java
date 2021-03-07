package leetcode.to200;

/**
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 * Subject: Dynamic Programming
 * #Hard #hard
 */
public class _132_PalindromePartitioningII {

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];

        for (int c = 0; c < len; c++) {
            int min = c;
            for (int r = 0; r <= c; r++) {
                if (s.charAt(c) == s.charAt(r) && (c - r < 2 || isPalindrome[r + 1][c - 1])) {
                    isPalindrome[r][c] = true;
                    min = r == 0 ? 0 : Math.min(min, cuts[r - 1] + 1);
                }
            }
            cuts[c] = min;
        }
        return cuts[len - 1];
    }


    public static void main(String[] args) {
        System.out.println(new _132_PalindromePartitioningII().minCut("aaaaab"));
    }
}
