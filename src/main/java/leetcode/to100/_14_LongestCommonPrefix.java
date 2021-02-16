package leetcode.to100;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 * Subject: String
 * #Easy, #Attention
 */
public class _14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    //Provide a second solution.
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
        }
        return result;
    }

    //Provide a third solution.
    public String longestCommonPrefix3(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String head = strs[0];
        for (int i = 0; i < head.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || head.charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(head.charAt(i));
        }
        return head;
    }
}
