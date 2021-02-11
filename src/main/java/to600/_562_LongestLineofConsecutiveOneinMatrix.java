package to600;


public class _562_LongestLineofConsecutiveOneinMatrix {


    public int longestLine(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int res = 0;
        int[] col = new int[M[0].length];
        int[] antiD = new int[M.length + M[0].length];
        int[] diag = new int[M.length + M[0].length];
        for (int i = 0; i < M.length; i++) {
            int row = 0;
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    row++;
                    col[j]++;
                    antiD[i + j]++;
                    diag[j - i + M.length]++;
                    res = Math.max(res, row);
                    res = Math.max(res, col[j]);
                    res = Math.max(res, antiD[i + j]);
                    res = Math.max(res, diag[j - i + M.length]);
                } else {
                    row = 0;
                    col[j] = 0;
                    antiD[i + j] = 0;
                    diag[j - i + M.length] = 0;
                }
            }
        }
        return res;
    }
}
