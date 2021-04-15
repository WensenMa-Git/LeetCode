package leetcode.to300;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/closest-binary-search-tree-value/
 * Subject: Tree
 * #Easy
 */
public class _270_ClosestBinarSearchTreeValue {

    // Preferred solution. time : O(logn) space : O(1)
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }


    // time : O(logn) space : O(n)
    public int closestValue2(TreeNode root, double target) {
        return helper(root, target, root.val);
    }

    public int helper(TreeNode root, double target, int val) {
        if (root == null) return val;
        if (Math.abs(root.val - target) < Math.abs(val - target)) {
            val = root.val;
        }
        if (root.val < target) {
            val = helper(root.right, target, val);
        } else if (root.val > target) {
            val = helper(root.left, target, val);
        }
        return val;
    }
}
