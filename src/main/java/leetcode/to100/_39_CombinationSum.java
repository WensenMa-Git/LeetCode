package leetcode.to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 * Subject: Backtrack
 * #Medium
 */
public class _39_CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(res, new ArrayList<Integer>(), candidates, target, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(res, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }

    //Provide a second solution.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrack(res, tempList, candidates, target, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, List<Integer> tempList, int[] candidates, int gap, int start) {
        if (gap == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (gap < 0) return;
            tempList.add(candidates[i]);
            backTrack(res, tempList, candidates, gap - candidates[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }
}
