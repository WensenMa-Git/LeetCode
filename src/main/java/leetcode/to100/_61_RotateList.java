package leetcode.to100;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/rotate-list/
 * Subject: LinkedList
 * #Medium
 */
public class _61_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode index = head;
        int len = 1;
        while (index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        for (int i = 1; i < len - k % len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }

    //Provide a second solution (Preferred)
    public ListNode rotateRight2(ListNode head, int k) {
        if(head == null) return null;
        int count = 1;
        ListNode p = head;
        while(p.next != null){
            p = p.next;
            count++;
        }
        k = k % count;
        if(k == 0) return head;
        p.next = head;

        for(int i = 0; i < count - k; i++){
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;

        return newHead;
    }

    public ListNode rotateRight3(ListNode head, int k) {
        if(head == null) return head;
        int len = 0;
        ListNode p = head;
        ListNode last = head;
        while(p != null) {
            last = p;
            p = p.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        last.next = head;
        ListNode result = slow.next;
        slow.next = null;
        return result;
    }

}
