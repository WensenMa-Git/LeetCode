package leetcode.to100;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * Subject: LinkedList
 * #Medium
 */
public class _2_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }

    //Provide a second solution (Preferred)
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = 0;
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            int num2 = 0;
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        return dummyHead.next;
    }
}


