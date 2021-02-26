package leetcode.to100;


import leetcode.dependency.ListNode;

public class _86_PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0),
                bigHead = new ListNode(0),
                small = smallHead,
                big = bigHead;
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        small.next = bigHead.next;
        return smallHead.next;
    }

    //Provide a second solution (Preferred)
    public ListNode partition2(ListNode head, int x) {
        ListNode largeHead = new ListNode(0), smallHead = new ListNode(0), large = largeHead, small = smallHead;
        while(head != null) {
            ListNode copy = new ListNode(head.val);
            if (head.val >= x) {
                large.next = copy;
                large = copy;
            } else {
                small.next = copy;
                small = copy;
            }
            head = head.next;
        }
        small.next = largeHead.next;
        return smallHead.next;
    }

    //Provide a third solution (Preferred)
    public ListNode partition3(ListNode head, int x) {
        ListNode largeHead = new ListNode(0), smallHead = new ListNode(0), large = largeHead, small = smallHead;
        while(head != null) {
            ListNode next = head.next;
            if (head.val >= x) {
                large.next = head;
                large = head;
            } else {
                small.next = head;
                small = head;
            }
            head.next = null;
            head = next;
        }
        small.next = largeHead.next;
        return smallHead.next;
    }
}
