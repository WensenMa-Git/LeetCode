package leetcode.to800;

/**
 * https://leetcode.com/problems/range-module/
 * Subject: Design
 * #Hard #hard #Google
 */
public class _715_RangeModule {

    class Node {
        int s;
        int e;
        Node left;
        Node right;
        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    Node mRoot;

    public _715_RangeModule() {

    }

    public void addRange(int left, int right) {
        mRoot = add(mRoot, left, right);
    }

    public boolean queryRange(int left, int right) {
        return query(mRoot, left, right);
    }

    public void removeRange(int left, int right) {
        mRoot = remove(mRoot, left, right);
    }

    private Node add(Node node, int s, int e) {
        if(s >= e)
            return node;
        if(node == null)
            return new Node(s, e);
        if(node.s >= e) {
            node.left = add(node.left, s, e);
        } else if(node.e <= s) {
            node.right = add(node.right, s, e);
        } else {
            node.left = add(node.left, s, node.s);
            node.right = add(node.right, node.e, e);
        }
        return node;
    }

    private Node remove(Node node, int s, int e) {
        if(s >= e)
            return node;
        if(node == null)
            return null;
        if(node.s >= e) {
            node.left = remove(node.left, s, e);
        } else if(node.e <= s) {
            node.right = remove(node.right, s, e);
        } else {
            node.left = remove(node.left, s, node.s);
            node.right = remove(node.right, node.e, e);
            node.left = add(node.left, node.s, s);
            node.right = add(node.right, e, node.e);
            node = remove(node);
        }
        return node;
    }

    private boolean query(Node node, int s, int e) {
        if(s >= e)
            return true;
        if(node == null)
            return false;
        if(node.s >= e) {
            return query(node.left, s, e);
        } else if(node.e <= s) {
            return query(node.right, s, e);
        } else if(s >= node.s && e <= node.e) {
            return true;
        } else {
            return query(node.left, s, node.s) && query(node.right, node.e, e);
        }
    }

    private Node remove(Node node) {
        if(node == null)
            return null;
        if(node.left == null)
            return node.right;

        Node p = node;
        Node c = node.left;
        while(c.right != null) {
            p = c;
            c = c.right;
        }
        if(c == p.left)
            p.left = c.left;
        if(c == p.right)
            p.right = c.left;

        c.left = node.left;
        c.right = node.right;
        return c;
    }

}
