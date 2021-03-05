package leetcode.to200;

import leetcode.dependency.RandomListNode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * Subject: LinkedList
 * #Medium
 */
public class _138_CopyListwithRandomPointer {

    //Preferred solution.
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    //Provide a second solution. (Preferred)
    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            RandomListNode temp = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = temp;
            p = temp;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode d = dummyHead;
        while (p != null) {
            d.next = p.next;
            d = d.next;
            p.next = d.next;
            p = p.next;
        }
        return dummyHead.next;
    }

    public RandomListNode copyRandomList3(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode next;
        //next copy
        while (cur != null) {
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        //random copy
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy;
        RandomListNode copycur = dummy;

        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copycur.next = copy;
            copycur = copy;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }
}
