package jianzhiOffer;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

// 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。

public class Offer54 {
    // 倒叙数组
    private List<Integer> nums;

    public int kthLargest(TreeNode root, int k) {
        nums = new LinkedList<>();
        midOrder(root);
        return nums.get(k - 1);
    }

    private void midOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        nums.add(0, node.val);
        midOrder(node.right);
    }
}
