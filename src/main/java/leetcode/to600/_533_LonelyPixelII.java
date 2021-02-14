package leetcode.to600;

import java.util.HashMap;


public class _533_LonelyPixelII {


    public int findBlackPixel(char[][] picture, int N) {
        HashMap<String, Integer> map = new HashMap<>();
        int[] col = new int[picture[0].length];
        for (int i = 0; i < picture.length; i++) {
            int row = 0;
            for (int j = 0; j < picture[0].length; j++) {
                if (picture[i][j] == 'B') {
                    col[j]++;
                    row++;
                }
            }
            if (row == N) {
                String s = new String(picture[i]);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int res = 0;
        for (String s : map.keySet()) {
            if (map.get(s) != N) continue;
            for (int i = 0; i < col.length; i++) {
                if (s.charAt(i) == 'B' && col[i] == N) {
                    res += N;
                }
            }
        }
        return res;
    }
}
