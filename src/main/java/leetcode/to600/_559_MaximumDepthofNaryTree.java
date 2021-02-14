package leetcode.to600;


import leetcode.dependency.Node;

public class _559_MaximumDepthofNaryTree {

    int res = 0;

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return res;
    }

    public void helper(Node node, int depth) {
        if (node == null) return;
        res = Math.max(res, depth);
        for (Node child : node.children) {
            helper(child, depth + 1);
        }
    }
}
