package jianzhiOffer;

import utils.ListNode;

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode front = head;
        for (int i = 0; i < k - 1; i++) {
            front = front.next;
            if (front == null) {
                return null;
            }
        }
        ListNode back = head;
        while(front.next != null) {
            front = front.next;
            back = back.next;
        }
        return back;
    }
}
