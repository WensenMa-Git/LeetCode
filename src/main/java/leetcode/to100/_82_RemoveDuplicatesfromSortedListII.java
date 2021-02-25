package leetcode.to100;

import leetcode.dependency.ListNode;

public class _82_RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int sameNum = p.next.val;
                while (p.next != null && p.next.val == sameNum) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    //Provide a second solution (Preferred)
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return head;
        ListNode copy = new ListNode(0);
        copy.next = head;

        ListNode cur = copy.next;
        ListNode prev = copy;
        boolean flag = false;

        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                flag = true;
            } else {
                if (flag) {
                    prev.next = cur.next;
                    flag = false;
                } else {
                    prev = cur;
                }
            }
            cur = cur.next;
        }
        if (flag) prev.next = cur.next;
        return copy.next;
    }
}
