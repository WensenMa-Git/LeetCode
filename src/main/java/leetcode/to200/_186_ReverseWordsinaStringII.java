package leetcode.to200;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/
 * Subject: Two Pointer
 * #Medium
 */
public class _186_ReverseWordsinaStringII {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ') {
                r++;
            }
            reverse(s, l, r - 1);
            r++;
        }
    }

    private void reverse(char[] s, int i, int j) {
        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    //Provide a second solution.
    public void reverseWords2(char[] str) {
        reverse(str, 0, str.length - 1);
        for(int left = 0, right = 0; right <= str.length; right++){
            if(right == str.length || str[right] == ' '){
                reverse(str, left, right -1);
                left = right + 1;
            }
        }
    }

    //Provide a third solution (Preferred).
    public void reverseWords3(char[] s) {
        reverse(s, 0, s.length - 1);
        for (int L = s.length - 1, R = s.length; L >= 0; L--) {
            if (s[L] == ' ') {
                R = L;
            } else {
                if (L == 0 || s[L - 1] == ' ') {
                    reverse (s, L, R - 1);
                }
            }
        }
    }
}
