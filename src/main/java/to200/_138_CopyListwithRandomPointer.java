package to200;

import java.util.HashMap;


public class _138_CopyListwithRandomPointer {

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


    public RandomListNode copyRandomList2(RandomListNode head) {
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

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
