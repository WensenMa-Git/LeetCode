package leetcode.to500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class _465_OptimalAccountBalancing {


    int res;

    public int minTransfers(int[][] transactions) {
        res = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] transaction : transactions) {
            map.put(transaction[0], map.getOrDefault(transaction[0], 0) - transaction[2]);
            map.put(transaction[1], map.getOrDefault(transaction[1], 0) + transaction[2]);
        }
        List<Integer> debt = new ArrayList<>();
        for (int value : map.values()) {
            if (value != 0) {
                debt.add(value);
            }
        }
        helper(debt, 0, 0);
        return res;
    }

    public void helper(List<Integer> debt, int start, int count) {
        while (start < debt.size() && debt.get(start) == 0) {
            start++;
        }
        if (start == debt.size()) {
            res = Math.min(res, count);
            return;
        }
        for (int i = start + 1; i < debt.size(); i++) {
            if ((debt.get(start) < 0 && debt.get(i) > 0) || (debt.get(start) > 0 && debt.get(i) < 0)) {
                debt.set(i, debt.get(i) + debt.get(start));
                helper(debt, start + 1, count + 1);
                debt.set(i, debt.get(i) - debt.get(start));
            }
        }
    }
}
