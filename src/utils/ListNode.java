package utils;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {}

    public ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    ListNode(int[] list) {
        ListNode head = null;
        ListNode current = null;
        for (int i : list) {
            if (head == null) {
                head = new ListNode(i);
                current = head;
            } else {
                current.next = new ListNode(i);
                current = current.next;
            }
        }
        this.val = head.val;
        this.next = head.next;
    }
}