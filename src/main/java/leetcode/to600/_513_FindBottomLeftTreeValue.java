package leetcode.to600;

import leetcode.dependency.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


public class _513_FindBottomLeftTreeValue {

    int res = 0;
    int height = 0;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return -1;
        helper(root, 1);
        return res;
    }

    public void helper(TreeNode root, int depth) {
        if (root == null) return;
        if (height < depth) {
            res = root.val;
            height = depth;
        }
        helper(root.left, depth + 1);
        helper(root.right, depth + 1);
    }

    public int findBottomLeftValue2(TreeNode root) {
        if (root == null) return -1;
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res = cur.val;
            if (cur.right != null) queue.offer(cur.right);
            if (cur.left != null) queue.offer(cur.left);
        }
        return res;
    }

}
