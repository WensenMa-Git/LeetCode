package leetcode.to300;


import leetcode.dependency.TreeNode;

public class _298_BinaryTreeLongestConsecutiveSequence {

    private int res = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return res;
    }

    public void helper(TreeNode root, int max, int target) {
        if (root == null) return;
        if (root.val == target) {
            max++;
        } else max = 1;
        res = Math.max(res, max);
        helper(root.left, max, root.val + 1);
        helper(root.right, max, root.val + 1);
    }

}
