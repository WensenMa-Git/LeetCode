package leetcode.to100;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Subject: Tree Recurse
 * #Medium
 */
public class _98_ValidateBinarySearchTree {

    public static boolean isValidBST(TreeNode root) {

        if (root == null) return true;
        return helper(root, null, null);
    }

    public static boolean helper(TreeNode root, Integer min, Integer max) {

        if (root == null) return true;
        if (min != null && root.val <= min) return false;
        if (max != null && root.val >= max) return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    //Provide a second solution (Preferred)
    public boolean isValidBST2(TreeNode root) {
        return isValidBSTUtil(root, null, null);
    }

    private boolean isValidBSTUtil(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        return (max == null || max > node.val) && (min == null || min < node.val)
                && isValidBSTUtil(node.left, min, node.val) && isValidBSTUtil(node.right, node.val, max);
    }


    //Provide a third solution.
    private Integer pre = null;

    public boolean isValidBST3(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left) && isValidNode(root) && isValidBST(root.right);
    }

    private boolean isValidNode(TreeNode node) {
        if (pre == null || pre < node.val) {
            pre = node.val;
            return true;
        }
        return false;
    }

}
