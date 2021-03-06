package leetcode.to100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * Subject: Backtrack
 * #Medium
 */
public class _46_Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }

    public static void helper(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;  // O(n)
            list.add(nums[i]);
            helper(res, list, nums);
            list.remove(list.size() - 1);
        }
    }

    // time : O(n!) space : O(n);
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        helper2(res, 0, nums);
        return res;
    }

    public static void helper2(List<List<Integer>> res, int start, int[] nums) {
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            helper2(res, start + 1, nums);
            swap(nums, start, i);
        }
    }

    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    //Provide a third solution (Preferred)
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        permuteUtil(lists, new ArrayList<>(), nums);
        return lists;
    }

    private void permuteUtil(List<List<Integer>> lists, ArrayList<Integer> tempList, int[] nums){
        if(tempList.size() == nums.length){
            lists.add(new ArrayList(tempList));
        }
        for(int i = 0; i < nums.length; i++){
            if(!tempList.contains(nums[i])){
                tempList.add(nums[i]);
                permuteUtil(lists, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
