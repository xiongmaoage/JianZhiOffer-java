package codeTop;

import utils.ListNode;

public class T148 {
    // 归并排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int linkLen = 0;
        for (ListNode node = head; node != null; node = node.next) {
            linkLen++;
        }
        return mergeSort(head, linkLen);
    }

    private ListNode mergeSort(ListNode head, int len) {
        if (len <= 1) {
            return head;
        }
        ListNode splitNode = head;
        for (int i = 0; i < len / 2 - 1; i++) {
            splitNode = splitNode.next;
        }
        ListNode head2 = splitNode.next;
        splitNode.next = null;
        ListNode list1 = mergeSort(head, len / 2);
        ListNode list2 = mergeSort(head2, len - len / 2);
        return mergeList(list1, list2);
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.val < head2.val) {
            head1.next = mergeList(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeList(head1, head2.next);
            return head2;
        }
    }
}
