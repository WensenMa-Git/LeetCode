package leetcode.to200;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Subject: Backtrack
 * #Medium
 */
public class _129_SumRoottoLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int num) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) +
                helper(root.right, num * 10 + root.val);
    }

    //Provide a second solution (Preferred)
    public int sumNumbers2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] res = new int[]{0, 0};
        backtrack(res, root);
        return res[0];
    }

    private void backtrack(int[] res, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            res[0] += (res[1] * 10 + root.val);
            return;
        }

        res[1] = res[1] * 10 + root.val;
        backtrack(res, root.left);
        backtrack(res, root.right);
        res[1] /= 10;
    }
}
