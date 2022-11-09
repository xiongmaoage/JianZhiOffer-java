package codeTop;

import utils.ListNode;

public class T143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int len = 0;
        for (ListNode node = head; node != null; node = node.next) {
            len++;
        }
        ListNode[] nodeList = new ListNode[len];
        ListNode node = head;
        for (int index = 0; index < len; index++) {
            nodeList[index] = node;
            node = node.next;
        }
        ListNode newHead = new ListNode();
        node = newHead;
        for (int i = 0; i < len / 2; i++) {
            int tail = len - 1 - i;
            node.next = nodeList[i];
            node.next.next = nodeList[tail];
            node = node.next.next;
        }
        if ((len & 1) != 0) {
            node.next = nodeList[len / 2];
            node = node.next;
        }
        node.next = null;
    }
}
