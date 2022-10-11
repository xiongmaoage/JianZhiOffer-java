package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public ListNode(int[] list) {
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

    @Override
    public String toString() {
        String str = "ListNode: ";
        ListNode node = this;
        str += this.val;
        while (node.next != null) {
            node = node.next;
            str += "-->" + node.val;
        }
        return str;
    }
}