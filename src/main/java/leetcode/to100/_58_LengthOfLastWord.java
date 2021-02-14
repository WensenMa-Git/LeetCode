package leetcode.to100;

/**
 * https://leetcode.com/problems/length-of-last-word/
 */
public class _58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }
}
