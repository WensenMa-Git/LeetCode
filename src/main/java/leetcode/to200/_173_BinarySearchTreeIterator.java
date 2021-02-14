package leetcode.to200;

import leetcode.dependency.TreeNode;

import java.util.Stack;

public class _173_BinarySearchTreeIterator {


    private final Stack<TreeNode> stack;
    private TreeNode cur;

    public _173_BinarySearchTreeIterator(TreeNode root) {
        cur = root;
        stack = new Stack<>();
    }


    public boolean hasNext() {
        return !stack.isEmpty() || cur != null;
    }


    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
