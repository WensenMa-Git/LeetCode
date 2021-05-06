package leetcode.toLast;

import java.util.TreeMap;

/**
 * https://leetcode.com/problems/snapshot-array/
 * Subject: TreeMap
 * #Medium #Google
 */
public class _1146_SnapshotArray {

    private TreeMap<Integer, Integer>[] A;
    private int snapId = 0;
    public _1146_SnapshotArray(int length) {
        A = new TreeMap[length];
        for (int i = 0; i < length; ++i) {
            A[i] = new TreeMap<Integer, Integer>();
            A[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        A[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snap_id) {
        return A[index].floorEntry(snap_id).getValue();
    }

}
