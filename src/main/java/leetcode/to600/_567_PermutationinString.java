package leetcode.to600;


public class _567_PermutationinString {

    public boolean checkInclusion(String s1, String s2) {
        int[] count = new int[128];
        for (char c : s1.toCharArray()) {
            count[c]++;
        }
        for (int i = 0, j = 0; i < s2.length(); i++) {
            if (--count[s2.charAt(i)] < 0) {
                while (count[s2.charAt(i)] != 0) {
                    count[s2.charAt(j++)]++;
                }
            } else if (i - j + 1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}
