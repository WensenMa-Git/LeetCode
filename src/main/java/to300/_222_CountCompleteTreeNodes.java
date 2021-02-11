package to300;

import dependency.TreeNode;

public class _222_CountCompleteTreeNodes {


    public int countNodes(TreeNode root) {
        // int left = helper(root, true);
        // int right = helper(root, false);
        int left = leftDepth(root);
        int right = rightDepth(root);

        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }

    private int rightDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.right;
            res++;
        }
        return res;
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        return isLeft ? helper(root.left, isLeft) + 1 : helper(root.right, isLeft) + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
