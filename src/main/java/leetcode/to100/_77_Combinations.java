package leetcode.to100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 * Subject: Backtrack
 * #Medium
 */
public class _77_Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int n, int k, int start) {
        if (k == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(res, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //Provide a second solution (Preferred)
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backtrack(res, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
