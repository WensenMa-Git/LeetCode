package leetcode.to200;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Subject: Tree Recurse
 * #Easy
 */
public class _104_MaximumDepthOfBinaryTree {

    //Preferred solution.
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth2(root.left) + 1;
        int r = maxDepth2(root.right) + 1;
        return Math.max(l, r);
    }
}
