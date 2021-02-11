package to300;


import dependency.ListNode;

public class _203_RemoveLinkedListElements {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }
}

