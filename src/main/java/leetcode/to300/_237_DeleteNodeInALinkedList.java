package leetcode.to300;

import leetcode.dependency.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * Subject: LinkedList
 * #Easy
 */
public class _237_DeleteNodeInALinkedList {

    public static void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
