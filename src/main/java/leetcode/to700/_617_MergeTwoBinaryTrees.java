package leetcode.to700;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class _617_MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }

        TreeNode newHead = new TreeNode(t1.val + t2.val);
        newHead.left = mergeTrees(t1.left, t2.left);
        newHead.right = mergeTrees(t1.right, t2.right);

        return newHead;

    }
}
