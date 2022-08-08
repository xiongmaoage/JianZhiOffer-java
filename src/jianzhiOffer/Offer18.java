package jianzhiOffer;

import utils.ListNode;

//给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。

// 把后面结点的值赋给本节点，并删除后面的结点
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        // 如果要删除的是头结点，返回头结点的第二个结点
        if (head.val == val) {
            return head.next;
        }
        // 找到val存在的结点
        ListNode node = head;
        while (node.val != val) {
            node = node.next;
        }
        // 如果要删除的点是尾结点，重新遍历链表，删除该节点
        if (node.next == null) {
            ListNode listNode = head;
            while (listNode.next != null && listNode.next.val != val) {
                listNode = listNode.next;
            }
            listNode.next = null;
            return head;
        }
        // 否则修改本节点的值，删除后一个结点
        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }
}
