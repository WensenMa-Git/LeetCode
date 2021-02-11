package to400;

import dependency.NestedInteger;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _339_NestedListWeightSum {

    // DFS
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 1);
    }

    public int helper(List<NestedInteger> nestedList, int depth) {
        int res = 0;
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger() * depth;
            } else {
                res += helper(nest.getList(), depth + 1);
            }
        }
        return res;
    }

    // BFS
    public int depthSum2(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int depth = 1;
        int res = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger nest = queue.poll();
                if (nest.isInteger()) {
                    res += nest.getInteger() * depth;
                } else {
                    queue.addAll(nest.getList());
                }
            }
            depth++;
        }
        return res;
    }


    public int depthSum3(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int depth = 1;
        int res = 0;
        while (nestedList.size() != 0) {
            List<NestedInteger> nextList = new LinkedList<>();
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    res += nest.getInteger() * depth;
                } else {
                    nextList.addAll(nest.getList());
                }
            }
            depth++;
            nestedList = nextList;
        }
        return res;
    }
}
