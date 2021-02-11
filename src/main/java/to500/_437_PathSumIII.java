package to500;

import dependency.TreeNode;

import java.util.HashMap;


public class _437_PathSumIII {


    // time : O(n ^ 2) space : O(n)
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode root, int sum) {
        int res = 0;
        if (root == null) return res;
        if (sum == root.val) res++;
        res += helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
        return res;
    }

    // time : O(n) space : O(n)
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int curSum, int sum, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        curSum += root.val;
        int res = map.getOrDefault(curSum - sum, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        res += helper(root.left, curSum, sum, map) + helper(root.right, curSum, sum, map);
        map.put(curSum, map.get(curSum) - 1);
        return res;
    }
}
