package codeTop;

import java.util.HashMap;
import java.util.LinkedList;

public class T146 {
}

class LRUCache {
    // 链表
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        ListNode() {}
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private HashMap<Integer, ListNode> map;
    private ListNode head;      // 头结点
    private ListNode tail;      // 尾结点
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new ListNode();
        this.tail = new ListNode();
        head.next = tail;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            this.moveNode2Head(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            this.moveNode2Head(node);
            return;
        }
        ListNode node = new ListNode(key, value);
        this.addNode2Head(node);
        map.put(key, node);
        if (size < capacity) {
            size++;
        } else if (size == capacity) {
            ListNode last = tail.prev;
            map.remove(last.key);
            last.prev.next = tail;
            tail.prev = last.prev;
        } else {
            System.out.println("error!");
        }
    }

    private void addNode2Head(ListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveNode2Head(ListNode node) {
        this.removeNode(node);
        this.addNode2Head(node);
    }
}
