package leetcode.to600;


public class _531_LonelyPixelI {


    public int findLonelyPixel(char[][] picture) {
        int[] col = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    col[j]++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < picture.length; i++) {
            int count = 0;
            int pos = 0;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    count++;
                    pos = j;
                }
                if (count == 1 && col[pos] == 1) {
                    res++;
                }
            }
        }

        return res;
    }
}
