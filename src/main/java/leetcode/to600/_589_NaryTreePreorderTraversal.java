package leetcode.to600;

import leetcode.dependency.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class _589_NaryTreePreorderTraversal {

    public static List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public static void helper(List<Integer> res, Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            helper(res, node);
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                stack.push(cur.children.get(i));
            }
            res.add(cur.val);
        }
        return res;
    }
}
