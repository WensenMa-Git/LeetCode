package leetcode.to200;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Subject: LinkedList
 * #Easy
 */
public class _160_IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);
        if (lenA > lenB) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int len(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }


    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    //Provide a third solution (Preferred)
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        int lenA = 0, lenB = 0;
        while (pointerA != null) {
            lenA++;
            pointerA = pointerA.next;
        }
        while (pointerB != null) {
            lenB++;
            pointerB = pointerB.next;
        }
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }

}
