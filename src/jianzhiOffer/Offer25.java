package jianzhiOffer;
import utils.ListNode;

//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的


public class Offer25 {
    private ListNode node; // 合并链表尾结点

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // 合并链表头结点，是一个空节点
        node = head;
        mergeList(l1, l2);
        return head.next;
    }

    private void mergeList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            node.next = node2;
            return;
        }
        if (node2 == null) {
            node.next = node1;
            return;
        }
        if (node1.val < node2.val) {
            node.next = node1;
            node = node.next;
            mergeList(node1.next, node2);
        } else {
            node.next = node2;
            node = node.next;
            mergeList(node1, node2.next);
        }
    }
}
