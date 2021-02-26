package leetcode.to100;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Subject: LinkedList
 * #Medium
 */
public class _92_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        for (int i = 1; i < left; i++) {
            cur = cur.next;
            pre = pre.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }

    //Provide a second
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode preleft = dummyHead;
        for (int i = 1; i < left; i++) {
            preleft = preleft.next;
        }
        ListNode leftnode = preleft.next;

        ListNode pre = null;
        ListNode cur = preleft.next;
        for (int i = 0; i <= right - left; i++) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre =  cur;
            cur = temp;
        }

        preleft.next = pre;
        leftnode.next = cur;
        return dummyHead.next;
    }
}
