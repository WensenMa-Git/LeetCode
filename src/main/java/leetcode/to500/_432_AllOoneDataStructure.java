package leetcode.to500;

import java.util.HashMap;
import java.util.LinkedHashSet;


public class _432_AllOoneDataStructure {


    HashMap<String, Node> map;
    Node head;
    Node tail;

    public _432_AllOoneDataStructure() {
        this.map = new HashMap<>();
        this.head = new Node(-1);
        this.tail = new Node(-1);
        head.next = tail;
        tail.pre = head;
    }

    public void addNext(Node cur, Node next) {
        next.pre = cur;
        next.next = cur.next;
        cur.next.pre = next;
        cur.next = next;
    }

    public void addPre(Node cur, Node pre) {
        pre.next = cur;
        pre.pre = cur.pre;
        cur.pre.next = pre;
        cur.pre = pre;
    }

    public void removeNode(Node node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            int curVal = curNode.val;
            Node nextNode;
            if (curNode.next.val == curVal + 1) {
                nextNode = curNode.next;
                nextNode.keys.add(key);
            } else {
                nextNode = new Node(curVal + 1);
                nextNode.keys.add(key);
                addNext(curNode, nextNode);
            }
            curNode.keys.remove(key);
            if (curNode.keys.size() == 0) {
                removeNode(curNode);
            }
            map.put(key, nextNode);
        } else {
            if (head.next.val == 1) {
                head.next.keys.add(key);
                map.put(key, head.next);
            } else {
                Node cur = new Node(1);
                cur.keys.add(key);
                addNext(head, cur);
                map.put(key, cur);
            }
        }
    }

    public void dec(String key) {
        if (map.containsKey(key)) {
            Node curNode = map.get(key);
            int curVal = curNode.val;
            if (curVal == 1) {
                curNode.keys.remove(key);
                if (curNode.keys.size() == 0) {
                    removeNode(curNode);
                }
                map.remove(key);
            } else {
                Node preNode;
                if (curNode.pre.val == curVal - 1) {
                    preNode = curNode.pre;
                    preNode.keys.add(key);
                } else {
                    preNode = new Node(curVal - 1);
                    preNode.keys.add(key);
                    addPre(curNode, preNode);
                }
                curNode.keys.remove(key);
                if (curNode.keys.size() == 0) {
                    removeNode(curNode);
                }
                map.put(key, preNode);
            }
        }
    }

    public String getMaxKey() {
        if (tail.pre == head) {
            return "";
        } else {
            return tail.pre.keys.iterator().next();
        }
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        } else {
            return head.next.keys.iterator().next();
        }
    }

    class Node {
        int val;
        LinkedHashSet<String> keys;
        Node pre;
        Node next;

        public Node(int val) {
            this.val = val;
            this.keys = new LinkedHashSet<>();
        }
    }
}
