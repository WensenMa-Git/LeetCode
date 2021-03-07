package leetcode.to200;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Subject: LinkedList
 * #Easy
 */
public class _141_LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
