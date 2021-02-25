package leetcode.to100;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Subject: LinkedList
 * #Easy
 */
public class _83_RemoveDuplicatesfromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
