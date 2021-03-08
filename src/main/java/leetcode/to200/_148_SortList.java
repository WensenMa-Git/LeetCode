package leetcode.to200;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/sort-list/
 * Subject: LinkedList
 * #Medium #Attention
 */
public class _148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = getMiddle(head);
        ListNode next = middle.next;
        middle.next = null;
        return merge(sortList(head), sortList(next));
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a == null) cur.next = b;
        else cur.next = a;
        return dummy.next;
    }

    //Provide a second solution (Preferred).
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMidNode(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return merge2(left, right);
    }

    public ListNode findMidNode(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge2(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                head = head.next;
                left = left.next;
            } else {
                head.next = right;
                head = head.next;
                right = right.next;
            }
        }
        if (left != null) {
            head.next = left;
        }
        if (right != null) {
            head.next = right;
        }
        return dummy.next;
    }
}
