package jianzhiOffer;

import utils.ListNode;

// 输入两个链表，找出它们的第一个公共节点。

public class Offer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getTailAndLength(headA);
        int lenB = getTailAndLength(headB);
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        if (lenA - lenB >= 0) {
            for (int i = 0; i < lenA - lenB; i++) {
                nodeA = nodeA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                nodeB = nodeB.next;
            }
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }

    // 返回链表长度
    private int getTailAndLength(ListNode head) {
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            len++;
        }
        return len;
    }

}
