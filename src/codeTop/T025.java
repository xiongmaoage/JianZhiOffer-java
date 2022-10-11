package codeTop;

import utils.ListNode;

public class T025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode newHead = new ListNode();
        ListNode newNode = newHead; // 遍历新链表用的结点
        ListNode node = head;   // 遍历用的结点
        while (true) {
            ListNode reverseHead = node;    // 逆转链表的第一个节点
            for (int i = 0; i < k - 1; i++) {
                if (node == null) {
                    break;
                }
                node = node.next;
            }
            if (node == null) {
                break;
            }
            // 此时需要反转的链表从reverseHead开始，到node结束，node之后是新的反转reverseHead
            ListNode nextNode = node.next;
            node.next = null;
            newNode.next = reverseLinkList(reverseHead);
            newNode = reverseHead;
            newNode.next = nextNode;
            node = nextNode;
        }
        return newHead.next;
    }

    private ListNode reverseLinkList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
