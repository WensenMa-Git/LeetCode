package leetcode.to100;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * #Hard
 */
public class _76_MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) total--;
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++cnt[s.charAt(j++)] > 0) total++;
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }

    //Provide a second solution (Perferred)
    public String minWindow2(String s, String t) {
        int[] counts = new int[256];
        char[] sChars = s.toCharArray();
        int counter = t.length();
        for(char c: t.toCharArray()){
            counts[c]++;
        }
        int resL = 0, resR = 2147483647;
        for(int head = 0, tail = 0; tail < sChars.length; tail++){
            if(counts[sChars[tail]]-- > 0){
                counter--;
            }
            while(counter == 0){
                if(tail - head < resR - resL){
                    resR = tail;
                    resL = head;
                }
                if(counts[sChars[head++]]++ == 0){
                    counter++;
                }
            }
        }
        return resR == 2147483647? "" : s.substring(resL, resR + 1);
    }
}
