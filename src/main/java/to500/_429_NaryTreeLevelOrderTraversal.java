package to500;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class _429_NaryTreeLevelOrderTraversal {


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                curLevel.add(cur.val);
                for (Node node : cur.children) {
                    queue.offer(node);
                }
                res.add(curLevel);
            }
        }

        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
