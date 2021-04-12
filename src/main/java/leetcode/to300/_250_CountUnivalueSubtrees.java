package leetcode.to300;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/count-univalue-subtrees/
 * Subject: Tree
 * #Medium
 */
public class _250_CountUnivalueSubtrees {

    int res;

    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    public boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean left = helper(root.left);
        boolean right = helper(root.right);

        if (left && right) {
            if (root.left != null && root.val != root.left.val) {
                return false;
            }
            if (root.right != null && root.val != root.right.val) {
                return false;
            }
            res++;
            return true;
        }
        return false;
    }

    //Provide a second solution. (Preferred)
    public int countUnivalSubtrees2(TreeNode root) {
        if (root == null)
            return 0;

        int cnt = 0;
        if (isUnival(root, root.val)) {
            cnt++;
        }

        cnt = cnt + countUnivalSubtrees2(root.left);
        cnt = cnt + countUnivalSubtrees2(root.right);

        return cnt;
    }

    boolean isUnival(TreeNode node, int val) {

        if (node.left == null && node.right == null && val == node.val) {
            return true;
        }

        return node.val == val && (node.left == null || (node.left != null && isUnival(node.left, val)))
                && (node.right == null || (node.right != null && isUnival(node.right, val)));

    }
}
