package jianzhiOffer;

// 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。

// 方法非常巧妙，值得复习
public class Offer35 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copyList(head);
        copyRandomPoint(head);
        return restoreList(head);
    }

    // 在每一个原结点的后面增添一个新结点
    private static void copyList(Node head) {
        Node node = head;
        while (node != null) {
            Node newNode = new Node(node.val);
            Node next = node.next;
            node.next = newNode;
            newNode.next = next;
            node = next;
        }
    }

    // 复制每一个random指针
    private static void copyRandomPoint(Node head) {
        Node node = head;
        while (node != null) {
            Node newNode = node.next;
            Node random = node.random;
            if (random == null) {
                newNode.random = null;
            } else {
                newNode.random = random.next;
            }
            node = node.next.next;
        }
    }

    private static Node restoreList(Node head) {
        Node newHead = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node newNode = node.next;
            node.next = node.next.next;
            if (newNode.next != null) {
                newNode.next = newNode.next.next;
            }
        }
        return newHead;
    }

}
