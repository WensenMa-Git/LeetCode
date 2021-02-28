package leetcode.to200;

import leetcode.dependency.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Subject: Tree Build
 * #Medium
 */
public class _106_ConstructBinaryTreeFromInorderandPostorderTraversal {

    int pInorder;
    int pPostorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return helper(inorder, postorder, null);
    }

    public TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        if (inorder[pInorder] != root.val) {
            root.right = helper(inorder, postorder, root);
        }
        pInorder--;
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = helper(inorder, postorder, end);
        }
        return root;
    }


    //Provide a second solution (Preferred)
    private int pIndex = 0;

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        pIndex = postorder.length - 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        return buildUtil(inorder, postorder, map, 0, inorder.length - 1);
    }

    private TreeNode buildUtil(int[] inorder, int[] postorder, Map<Integer, Integer> map, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        TreeNode node = new TreeNode(postorder[pIndex--]);
        int iIndex = map.get(node.val);
        node.right = buildUtil(inorder, postorder, map, iIndex + 1, inEnd);
        node.left = buildUtil(inorder, postorder, map, inStart, iIndex - 1);
        return node;
    }
}
