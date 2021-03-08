package leetcode.to200;

import leetcode.dependency.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-upside-down/
 * Subject: Tree, LinkedList
 * #Medium #hard
 */
public class _156_BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }

    //Provide a second solution
    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode pre = null, preRight = null;
        while(root != null){
            TreeNode temp = root.left;
            root.left = preRight;
            preRight = root.right;
            root.right = pre;
            pre = root;
            root = temp;
        }
        return pre;
    }

    //Provide a third solution
    public TreeNode upsideDownBinaryTree3(TreeNode root) {
        if(root == null) return null;
        if(root.left == null && root.right == null) return root;

        TreeNode left = upsideDownBinaryTree(root.left);
        TreeNode right = upsideDownBinaryTree(root.right);
        //clean curr node pointers
        root.left = null;
        root.right = null;

        //assgin new parent node
        TreeNode curr = left;
        while(curr.right != null) curr = curr.right;
        curr.right = root;
        curr.left = right;

        return left;
    }
}
