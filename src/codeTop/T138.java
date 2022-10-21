package codeTop;

public class T138 {
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

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 扩充链表，在每一个节点后面增加一个结点
        for (Node node = head; node != null; node = node.next) {
            Node copyNode = new Node(node.val);
            copyNode.next = node.next;
            node.next = copyNode;
            node = copyNode;
        }
        // 复制random结点
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = node.next;
            if (node.random == null) {
                newNode.random = null;
            } else {
                newNode.random = node.random.next;
            }
        }
        // 将链表拆开成两个独立的链表
        Node newHead = new Node(0);
        Node newTail = newHead;
        for (Node node = head; node != null; node = node.next) {
            newTail.next = node.next;
            newTail = newTail.next;
            node.next = node.next.next;
        }
        return newHead.next;
    }
}
