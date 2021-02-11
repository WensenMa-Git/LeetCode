package to500;


public class _424_LongestRepeatingCharacterReplacement {


    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0;
        int res = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            max = Math.max(max, ++count[s.charAt(i) - 'A']);
            while (i - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
