package leetcode.to100;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Subject: LinkedList
 * #Medium
 */
public class _19_RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode slow = dummy;
        ListNode fast = dummy;
        dummy.next = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * Pay Attention (Wrong Solution)
     * False solution because when there is only one note in the list, and n = 1, there will be runtime exception.
     */
    public ListNode removeNthFromEnd_WrongSolution(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < n; i++) {
            first = first.next;
        }
        while(first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return head;
    }
}
