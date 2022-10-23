package codeTop;

import utils.ListNode;

public class T142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        // 设前摇为a，环长为b，走了k步，则此时slow走了k步，fast走了2k步相遇了，有k%b==0.不妨设k=nb
        // 则slow走了nb步，还差a步即可到达环首，此时用一个结点在head同步运行即可
        ListNode ans = head;
        while (ans != slow) {
            ans = ans.next;
            slow = slow.next;
        }
        return ans;
    }
}
