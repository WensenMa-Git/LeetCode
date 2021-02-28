package leetcode.to200;


import leetcode.dependency.ListNode;
import leetcode.dependency.TreeNode;

public class _109_ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return toBST(head, null);
    }

    public TreeNode toBST(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = toBST(head, slow);
        root.right = toBST(slow.next, tail);
        return root;
    }

    //Provide a second solution (Preferred)
    private ListNode node = null;

    public TreeNode sortedListToBST2(ListNode head) {
        ListNode p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        node = head;
        return sortedListToBSTUtil(0, count - 1);
    }

    private TreeNode sortedListToBSTUtil(int left, int right) {
        if (left > right) return null;
        int middle = (left + right) / 2;
        TreeNode leftNode = sortedListToBSTUtil(left, middle - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = leftNode;
        node = node.next;
        root.right = sortedListToBSTUtil(middle + 1, right);
        return root;
    }
}
