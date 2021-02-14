package leetcode.to500;

import java.util.List;


public class _469_ConvexPolygon {


    public boolean isConvex(List<List<Integer>> points) {
        int size = points.size();
        int flag = 0;
        for (int i = 0; i < points.size(); i++) {
            int ori = helper(points.get(i % size), points.get((i + 1) % size), points.get((i + 2) % size));
            if (ori == 0) {
                continue;
            }
            if (flag == 0) {
                flag = ori;
            } else {
                if (flag != ori) {
                    return false;
                }
            }
        }
        return true;
    }

    public int helper(List<Integer> p1, List<Integer> p2, List<Integer> p3) {
        int val = (p3.get(0) - p2.get(0)) * (p2.get(1) - p1.get(1)) -
                (p2.get(0) - p1.get(0)) * (p3.get(1) - p2.get(1));
        if (val < 0) {
            return 2;
        } else if (val == 0) {
            return 0;
        }
        return 1;
    }
}
