package leetcode.to400;

import leetcode.dependency.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class _352_DataStreamasDisjointIntervals {


    TreeMap<Integer, Interval> treeMap;

    public _352_DataStreamasDisjointIntervals() {
        treeMap = new TreeMap<>();
    }

    // time : O(logn)
    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);
        if (lowerKey != null && higherKey != null && treeMap.get(lowerKey).end + 1 == val
                && val + 1 == treeMap.get(higherKey).start) {
            treeMap.get(lowerKey).end = treeMap.get(higherKey).end;
            treeMap.remove(higherKey);
        } else if (lowerKey != null && val <= treeMap.get(lowerKey).end + 1) {
            treeMap.get(lowerKey).end = Math.max(treeMap.get(lowerKey).end, val);
        } else if (higherKey != null && treeMap.get(higherKey).start - 1 == val) {
            treeMap.put(val, new Interval(val, treeMap.get(higherKey).end));
            treeMap.remove(higherKey);
        } else {
            treeMap.put(val, new Interval(val, val));
        }
    }

    public List<Interval> getIntervals() {
        return new ArrayList<>(treeMap.values());
    }
}
