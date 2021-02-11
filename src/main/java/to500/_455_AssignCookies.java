package to500;

import java.util.Arrays;


public class _455_AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                res++;
                i++;
                j++;
            } else if (g[i] > s[j]) {
                j++;
            }
        }
        return res;
    }
}
