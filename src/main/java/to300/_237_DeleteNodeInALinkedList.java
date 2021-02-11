package to300;


import dependency.ListNode;

public class _237_DeleteNodeInALinkedList {


    public static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
