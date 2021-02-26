package leetcode.to100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/subsets-ii/
 * Subject: Backtrack
 * #Medium
 */
public class _90_SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            backtrack(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
