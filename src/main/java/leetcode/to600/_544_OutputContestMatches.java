package leetcode.to600;


public class _544_OutputContestMatches {


    public String findContestMatch(int n) {
        String[] res = new String[n];
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(i + 1);
        }
        while (n > 1) {
            for (int i = 0; i < n / 2; i++) {
                res[i] = "(" + res[i] + "," + res[n - 1 - i] + ")";
            }
            n /= 2;
        }
        return res[0];
    }
}
