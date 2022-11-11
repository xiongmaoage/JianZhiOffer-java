package codeTop;

import utils.ListNode;

public class T024 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode outHead = newHead;
        while (true) {
            ListNode inHead = outHead.next;
            if (inHead == null || inHead.next == null) {
                break;
            }
            ListNode inTail = inHead.next;
            ListNode outTail = inTail.next;
            outHead.next = inTail;
            inTail.next = inHead;
            inHead.next = outTail;
            // 更新
            outHead = inHead;
        }
        return newHead.next;
    }
}
