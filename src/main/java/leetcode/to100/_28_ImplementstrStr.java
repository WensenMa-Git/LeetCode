package leetcode.to100;

/**
 * https://leetcode.com/problems/implement-strstr/
 * Subject: String
 * #Easy
 */
public class _28_ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i < haystack.length(); i++) {
            if (i + needle.length() > haystack.length()) {
                break;
            }
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                if (j == needle.length() - 1) {
                    return i;
                }
            }
        }

        return -1;
    }

    //Provide a second solution (Preferred)
    public int strStr2(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j <= needle.length(); j++) {
                if (j == needle.length()) return i;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
        return -1;
    }
}
