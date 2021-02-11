package to400;

import dependency.NestedInteger;

import java.util.LinkedList;
import java.util.List;


public class _364_NestedListWeightSumII {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        return helper(nestedList, 0);
    }

    private int helper(List<NestedInteger> nestedList, int res) {
        List<NestedInteger> nextList = new LinkedList<>();
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                res += nest.getInteger();
            } else {
                nextList.addAll(nest.getList());
            }
        }
        res += nextList.isEmpty() ? 0 : helper(nestedList, res);
        return res;
    }

    public int depthSumInverse2(List<NestedInteger> nestedList) {
        if (nestedList == null) return 0;
        int sum = 0;
        int res = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextList = new LinkedList<>();
            for (NestedInteger nest : nestedList) {
                if (nest.isInteger()) {
                    sum += nest.getInteger();
                } else {
                    nextList.addAll(nest.getList());
                }
            }
            res += sum;
            nestedList = nextList;
        }
        return res;
    }
}
