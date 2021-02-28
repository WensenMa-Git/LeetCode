package leetcode.to200;

import leetcode.dependency.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Subject: Tree Build
 * #Medium
 */
public class _105_ConstructBinaryTreeFromPreorderandInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

    //Provide a second solution (Preferred)
    private int preIndex = 0;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildTreeUtil(preorder, inorder, map, 0, inorder.length - 1);
    }

    private TreeNode buildTreeUtil(int[] preorder, int[] inorder, Map<Integer, Integer> map, int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[preIndex++]);
        int rootIndex = map.get(root.val);
        root.left = buildTreeUtil(preorder, inorder, map, left, rootIndex - 1);
        root.right = buildTreeUtil(preorder, inorder, map, rootIndex + 1, right);
        return root;
    }

}
