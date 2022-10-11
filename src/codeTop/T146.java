package codeTop;

import java.util.HashMap;

public class T146 {
}

class LRUCache {
    // 链表
    class BiListNode {
        int key;
        int val;
        BiListNode next;
        BiListNode prev;
        BiListNode() {}
        BiListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private HashMap<Integer, BiListNode> map;
    private BiListNode head;      // 头结点
    private BiListNode tail;      // 尾结点
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new BiListNode();
        this.tail = new BiListNode();
        head.next = tail;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            BiListNode node = map.get(key);
            this.moveNode2Head(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            BiListNode node = map.get(key);
            node.val = value;
            this.moveNode2Head(node);
            return;
        }
        BiListNode node = new BiListNode(key, value);
        this.addNode2Head(node);
        map.put(key, node);
        if (size < capacity) {
            size++;
        } else if (size == capacity) {
            BiListNode last = tail.prev;
            map.remove(last.key);
            last.prev.next = tail;
            tail.prev = last.prev;
        } else {
            System.out.println("error!");
        }
    }

    private void addNode2Head(BiListNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(BiListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveNode2Head(BiListNode node) {
        this.removeNode(node);
        this.addNode2Head(node);
    }
}
