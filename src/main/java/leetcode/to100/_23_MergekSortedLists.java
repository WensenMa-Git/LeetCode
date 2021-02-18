package leetcode.to100;

import leetcode.dependency.ListNode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * Subject: LinkedList
 * #Hard #easy
 */
public class _23_MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0, lists.length - 1);
    }

    public ListNode sort(ListNode[] lists, int lo, int hi) {
        if (lo >= hi) return lists[lo];
        int mid = (hi - lo) / 2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
            if (cur.next != null) {
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }

    //Provide a third solution (Preferred)
    public ListNode mergeKLists3(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int right = lists.length - 1;
        while(right > 0){
            for(int left = 0; left < right; left++, right--){
                lists[left] = merge2(lists[left], lists[right]);
            }
        }
        return lists[0];
    }

    private ListNode merge2(ListNode n1, ListNode n2){

        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while(n1 != null && n2 != null){
            if(n1.val < n2.val){
                p.next = n1;
                n1 = n1.next;
            }else{
                p.next = n2;
                n2 = n2.next;
            }
            p = p.next;
        }
        if(n1 != null){
            p.next = n1;
        }else{
            p.next = n2;
        }
        return dummyHead.next;

    }
}
