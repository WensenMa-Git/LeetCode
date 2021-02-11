package to400;

import dependency.ListNode;

import java.util.Random;


public class _382_LinkedListRandomNode {

    private final ListNode head;
    private final Random rmd;

    public _382_LinkedListRandomNode(ListNode head) {
        this.head = head;
        rmd = new Random();
    }


    public int getRandom() {
        ListNode temp = head;
        int res = temp.val;
        int i = 1;
        while (temp.next != null) {
            temp = temp.next;
            if (rmd.nextInt(++i) == 0) {
                res = temp.val;
            }
        }
        return res;
    }
}
