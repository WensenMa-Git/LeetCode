package leetcode.to100;

import java.util.ArrayList;
import java.util.List;


public class _78_Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index) {
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets2(int[] nums) {
        int length = nums.length;
        int size = (int) Math.pow(2, length);
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            subsets.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < size; j++) {
                if ((j >> i & 1) == 1) {
                    subsets.get(j).add(nums[i]);
                }
            }
        }
        return subsets;
    }
}
