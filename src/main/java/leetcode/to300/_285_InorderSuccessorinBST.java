package leetcode.to300;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/
 * Subject: Tree
 * #Medium
 */
public class _285_InorderSuccessorinBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (root.val <= p.val) {
                root = root.right;
            } else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public TreeNode successor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
            return successor(root.right, p);
        } else {
            TreeNode temp = successor(root.left, p);
            return (temp != null) ? temp : root;
        }
    }
}
