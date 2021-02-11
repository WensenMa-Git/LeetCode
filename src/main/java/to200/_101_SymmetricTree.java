package to200;

import dependency.TreeNode;

public class _101_SymmetricTree {


    public static boolean isSymmetric(TreeNode root) {

        if (root == null) return true;
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}
