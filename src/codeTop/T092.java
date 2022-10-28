package codeTop;

import utils.ListNode;

public class T092 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        // 找到需要翻转的前一个节点
        ListNode reverseOutHead = newHead;
        for (int i = 0; i < left - 1; i++) {
            reverseOutHead = reverseOutHead.next;
        }
        // 翻转right - left次
        ListNode reverseInTail = reverseOutHead.next;
        ListNode previous = null;
        ListNode current = reverseOutHead.next;
        for (int i = left; i < right; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        // 此时current指向right，current.next指向下一个，previous指向right - 1
        ListNode reverseInHead = current;
        ListNode reverseOutTail = current.next;
        current.next = previous;
        reverseOutHead.next = reverseInHead;
        reverseInTail.next = reverseOutTail;
        return newHead.next;
    }
}
