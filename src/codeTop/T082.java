package codeTop;

import utils.ListNode;

public class T082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode prev = newHead;
        ListNode node = head;
        while (node != null) {
            if (node.next == null) {
                break;
            }
            if (node.next.val == node.val) {
                int val = node.val;
                while (node != null && node.val == val) {
                    node = node.next;
                }
                prev.next = node;
            } else {
                prev = node;
                node = node.next;
            }
        }
        return newHead.next;
    }
}
