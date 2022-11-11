package codeTop;

import utils.ListNode;

public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = 1, len2 = 1;
        ListNode node1, node2;
        for (node1 = headA; node1.next != null; node1 = node1.next) {
            len1++;
        }
        for (node2 = headB; node2.next != null; node2 = node2.next) {
            len2++;
        }
        if (node1 != node2) {
            return null;
        }
        int dist = len1 - len2;
        node1 = headA;
        node2 = headB;
        if (dist >= 0) {
            for (int i = 0; i < dist; i++) {
                node1 = node1.next;
            }
        } else {
            for (int i = 0; i < -dist; i++) {
                node2 = node2.next;
            }
        }
        while (node1 != node2) {
            if (node1 == null || node2 == null) {
                return null;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

}
