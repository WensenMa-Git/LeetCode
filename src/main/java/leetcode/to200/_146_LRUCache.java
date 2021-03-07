package leetcode.to200;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 * Subject: Design, Cache
 * #Medium
 * Similar Questions: 460. LFU Cache
 */
public class _146_LRUCache {

    private final HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public _146_LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }

    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    //Provide a second solution (Preferred)
    /*
    private int capacity;
    private Map<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node == null) {
            if (map.size() == capacity) {
                map.remove(tail.pre.key);
                removeNode(tail.pre);
            }
            node = new ListNode(key, value);
            map.put(key, node);
        } else {
            removeNode(node);
            node.value = value;
        }
        addToHead(node);
    }

    private void removeNode(ListNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(ListNode node) {
        ListNode temp = head.next;
        head.next = node;
        temp.pre = node;
        node.pre = head;
        node.next = temp;
    }

    class ListNode {
        int key;
        int value;
        ListNode pre;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }
     */
}
