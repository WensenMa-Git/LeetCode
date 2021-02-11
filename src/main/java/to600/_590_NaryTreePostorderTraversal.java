package to600;

import dependency.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class _590_NaryTreePostorderTraversal {

    public static void helper(List<Integer> res, Node root) {
        if (root == null) return;
        for (Node node : root.children) {
            helper(res, node);
        }
        res.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root);
        return res;
    }

    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            List<Node> child = cur.children;
            res.addFirst(cur.val);
            for (Node node : child) {
                stack.push(node);
            }
        }
        return res;
    }
}
