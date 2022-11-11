package codeTop;

import utils.ListNode;
import utils.TreeNode;

public class T109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }
        ListNode middle = findMidNode(head);
        TreeNode root = new TreeNode(middle.val);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(middle.next);
        root.left = left;
        root.right = right;
        return root;
    }

    // 返回中间结点，并把中间结点和左子树断节
    private ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oneStep = head;
        ListNode twoStep = head;
        ListNode prev = head;
        while (twoStep != null) {
            twoStep = twoStep.next;
            if (twoStep == null) {
                break;
            }
            twoStep = twoStep.next;
            prev = oneStep;
            oneStep = oneStep.next;
        }
        prev.next = null;
        return oneStep;
    }
}
