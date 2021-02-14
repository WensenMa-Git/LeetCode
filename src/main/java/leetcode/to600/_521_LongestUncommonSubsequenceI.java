package leetcode.to600;


public class _521_LongestUncommonSubsequenceI {


    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
