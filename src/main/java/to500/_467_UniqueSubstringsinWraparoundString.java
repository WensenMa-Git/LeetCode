package to500;


public class _467_UniqueSubstringsinWraparoundString {


    public int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int curMax = 0;
        for (int i = 0; i < p.length(); i++) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1) || (p.charAt(i - 1) - p.charAt(i) == 25)) {
                curMax++;
            } else {
                curMax = 1;
            }
            count[p.charAt(i) - 'a'] = Math.max(curMax, count[p.charAt(i) - 'a']);
        }
        int res = 0;
        for (int num : count) {
            res += num;
        }
        return res;
    }
}
