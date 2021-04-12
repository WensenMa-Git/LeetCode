package leetcode.to300;

import java.util.List;

/**
 * https://leetcode.com/problems/flatten-2d-vector/
 * Subject: Array
 * #Medium
 */
public class _251_Flatten2DVector {

    int indexList, indexElement;
    List<List<Integer>> list;

    public _251_Flatten2DVector(List<List<Integer>> vec2d) {
        indexElement = 0;
        indexList = 0;
        list = vec2d;
    }

    //@Override
    public Integer next() {
        return list.get(indexList).get(indexElement++);
    }

    //@Override
    public boolean hasNext() {
        while (indexList < list.size()) {
            if (indexElement < list.get(indexList).size()) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}
