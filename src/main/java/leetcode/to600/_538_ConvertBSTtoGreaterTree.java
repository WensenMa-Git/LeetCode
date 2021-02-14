package leetcode.to600;


import leetcode.dependency.TreeNode;

public class _538_ConvertBSTtoGreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
