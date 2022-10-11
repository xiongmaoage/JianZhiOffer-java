package codeTop;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        Queue<TreeNode> currQueue = queue1;
        Queue<TreeNode> otherQueue = queue2;
        queue1.add(root);
        while (!currQueue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!currQueue.isEmpty()) {
                TreeNode node = currQueue.poll();
                list.add(node.val);
                if (node.left != null) {
                    otherQueue.offer(node.left);
                }
                if (node.right != null) {
                    otherQueue.offer(node.right);
                }
            }
            ans.add(list);
            Queue<TreeNode> temp = currQueue;
            currQueue = otherQueue;
            otherQueue = temp;
        }
        return ans;
    }
}
