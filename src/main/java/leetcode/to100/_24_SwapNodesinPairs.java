package leetcode.to100;


import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Subject: LinkedList
 * #Medium
 */
public class _24_SwapNodesinPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }

    //Provide a second solution (Preferred)
    public ListNode swapPairs2(ListNode head) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode p = dummyhead;
        while(p.next != null && p.next.next != null) {
            ListNode p1 = p.next;
            ListNode p2 = p1.next;
            ListNode p3 = p2.next;
            p2.next = p1;
            p1.next = p3;
            p.next = p2;
            p = p1;
        }
        return dummyhead.next;
    }
}
