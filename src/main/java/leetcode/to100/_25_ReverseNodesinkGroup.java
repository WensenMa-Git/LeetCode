package leetcode.to100;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Subject: LinkedList
 * #Hard
 */
public class _25_ReverseNodesinkGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;
        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }
        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }
            head = cur;
        }
        return head;
    }

    //Provide a second solution (Preferred)
    public ListNode reverseKGroup2(ListNode head, int k) {
        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;
        dummyhead.next = head;
        while(true) {
            ListNode p1 = head;
            for (int i = 0; i < k; i++) {
                if (head == null) {
                    return dummyhead.next;
                }
                head = head.next;
            }
            ListNode pre = null;
            ListNode p2 = p1;
            while(p2 != head) {
                ListNode temp = p2.next;
                p2.next = pre;
                pre = p2;
                p2 = temp;
            }
            p1.next = head;
            p.next = pre;
            p = p1;
        }
    }
}
