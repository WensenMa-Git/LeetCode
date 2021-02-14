package leetcode.to600;


import leetcode.dependency.TreeNode;

public class _549_BinaryTreeLongestConsecutiveSequenceII {

    int res;

    public int longestConsecutive(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int dcr = 1;
        int icr = 1;

        if (root.left != null) {
            if (root.left.val == root.val + 1) {
                icr = left[1] + 1;
            }
            if (root.left.val == root.val - 1) {
                dcr = left[0] + 1;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val + 1) {
                icr = Math.max(icr, right[1] + 1);
            }
            if (root.right.val == root.val - 1) {
                dcr = Math.max(dcr, right[0] + 1);
            }
        }

        res = Math.max(res, dcr + icr - 1);
        return new int[]{dcr, icr};
    }
}
