package leetcode.to300;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * Subject: Backtrack
 * #Medium
 */
public class _216_CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int start) {
        if (k == 0 && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            helper(res, list, k - 1, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

    //Provide a second solution (Preferred).
    public List<List<Integer>> combinationSum32(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int k, int n, int start) {
        if (k < 0 || n < 0) {
            return;
        } else if (k == 0 && n == 0) {
            res.add(new ArrayList<>(tempList));
        }

        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            backtrack(res, tempList, k - 1, n - i, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
