package leetcode.to500;


public class _426_ConvertBinarySearchTreetoSortedDoublyLinkedList {


    Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node(0, null, null);
        pre = dummy;
        helper(root);
        pre.right = dummy.right;
        dummy.right.left = pre;
        return dummy.right;
    }

    public void helper(Node root) {
        if (root == null) return;
        helper(root.left);
        pre.right = root;
        root.left = pre;
        pre = root;
        helper(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
