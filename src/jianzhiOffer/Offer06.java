package jianzhiOffer;

import utils.ListNode;

// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

// 想不到要用递归去做
public class Offer06 {
    private int[] ans;
    private int index = 0;

    public int[] reversePrint(ListNode head) {
        int count = 0;
        for (ListNode node = head; node != null; node = node.next) {
            count++;
        }
        ans = new int[count];
        f(head);
        return ans;
    }

    private void f(ListNode node) {
        if (node == null) {
            return;
        }
        f(node.next);
        print(node.val);
    }

    private void print(int a) {
        ans[index] = a;
        index++;
    }
}
