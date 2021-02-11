package to200;


import dependency.TreeLinkNode;

public class _116_PopulatingNextRightPointersinEachNode {

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }

    //space : O(1)
    public void connect2(TreeLinkNode root) {
        TreeLinkNode start = root;
        while (start != null) {
            TreeLinkNode cur = start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            start = start.left;
        }
    }
}
