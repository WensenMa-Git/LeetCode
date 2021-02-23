package leetcode.to100;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * Subject: String
 * #Easy
 */
public class _58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }

    //Provide a second solution (Preferred)
    public int lengthOfLastWord3(String s) {
        s = s.trim();
        return s.length() - s.lastIndexOf(' ') - 1;
    }
}
