package leetcode.to200;

import leetcode.dependency.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * Subject: Tree BFS
 * #Medium
 */
public class _117_PopulatingNextRightPointersinEachNodeII {

    public void connect(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else head = cur.left;
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else head = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            pre = null;
            head = null;
        }
    }

    //Provide a second solution.
    public void connect2(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        TreeLinkNode temp = new TreeLinkNode(0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeLinkNode pre = temp;
            for (int i = 0; i < size; i++) {
                pre.next = queue.poll();
                pre = pre.next;
                if (pre.left != null) queue.add(pre.left);
                if (pre.right != null) queue.add(pre.right);
            }
        }
    }

    //Provide a third solution. (Preferred)
    public void connect3(TreeLinkNode root) {
        if (root == null) return;

        while (root != null) {
            TreeLinkNode dummyHead = new TreeLinkNode(0);
            TreeLinkNode pre = dummyHead;
            while (root != null) {
                if (root.left != null) {
                    pre.next = root.left;
                    pre = pre.next;
                }
                if (root.right != null) {
                    pre.next = root.right;
                    pre = pre.next;
                }
                root = root.next;
            }
            root = dummyHead.next;
        }
    }
}
