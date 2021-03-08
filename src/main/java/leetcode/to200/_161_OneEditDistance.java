package leetcode.to200;

/**
 * https://leetcode.com/problems/one-edit-distance/
 * Subject: String
 * #Medium
 */
public class _161_OneEditDistance {

    public static boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return s.substring(i + 1).equals(t.substring(i));
                } else {
                    return t.substring(i + 1).equals(s.substring(i));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    //Provide a second solution (Preferred)
    public boolean isOneEditDistance2(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m > n) return isOneEditDistance(t, s);
        if (n > m + 1) return false;
        int i = 0;
        int shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i)) i++;
        if (i == m) return shift == 1;
        if (shift == 0) i++;
        while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == m;
    }
}
