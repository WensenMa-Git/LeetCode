package leetcode.to500;

import java.util.Random;
import java.util.TreeMap;


public class _497_RandomPointinNonoverlappingRectangles {


    TreeMap<Integer, Integer> map;
    int[][] rects;
    Random random;
    int area;

    public _497_RandomPointinNonoverlappingRectangles(int[][] rects) {
        this.rects = rects;
        map = new TreeMap<>();
        random = new Random();
        area = 0;

        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            area += (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            map.put(area, i);
        }
    }

    public int[] pick() {
        int rmd = map.ceilingKey(random.nextInt(area) + 1);
        int[] rect = rects[map.get(rmd)];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);
        return new int[]{x, y};
    }
}
