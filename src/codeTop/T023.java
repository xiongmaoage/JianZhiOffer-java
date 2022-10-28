package codeTop;

import utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T023 {
    PriorityQueue<ListNode> heap;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        heap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        // 把k个链表的第一个节点加入优先队列中
        for (ListNode node : lists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        return mergeLists();
    }

    private ListNode mergeLists() {
        if (heap.isEmpty()) {
            return null;
        }
        ListNode head = heap.poll();
        if (head.next != null) {
            heap.offer(head.next);
        }
        head.next = mergeLists();
        return head;
    }
}
