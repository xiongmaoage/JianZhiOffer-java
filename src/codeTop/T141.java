package codeTop;

import utils.ListNode;

public class T141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (fast == null) {
                return false;
            }
        } while (slow != fast);
        return true;
    }
}
