package jianzhiOffer;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

public class Offer32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        MyQueue queue = new MyQueue(root);
        List<List<Integer>> ans = new ArrayList<>();

        while(!queue.isEmpty()) {
            ArrayList<Integer> nodes = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                nodes.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            ans.add(nodes);
            queue.switchQueue();
        }
        return ans;
    }

    class MyQueue {
        private Queue<TreeNode> queue1;
        private Queue<TreeNode> queue2;
        private Queue<TreeNode> currentLevel;
        private Queue<TreeNode> nextLevel;

        MyQueue(TreeNode node) {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
            currentLevel = queue1;
            nextLevel = queue2;
            queue1.add(node);
        }

        void add(TreeNode element) {
            if (element != null) {
                nextLevel.add(element);
            }
        }

        TreeNode poll() {
            return currentLevel.poll();
        }

        boolean isEmpty() {
            return currentLevel.isEmpty();
        }

        void switchQueue() {
            Queue<TreeNode> temp = currentLevel;
            currentLevel = nextLevel;
            nextLevel = temp;
        }
    }
}
