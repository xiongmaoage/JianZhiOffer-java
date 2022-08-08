package jianzhiOffer;

import utils.ListNode;

//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
public class Offer23 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode back = null;
        ListNode now = head;
        while (now.next != null) {
            ListNode front = now.next;
            now.next = back;
            back = now;
            now = front;
        }
        now.next = back;
        return now;
    }
}
