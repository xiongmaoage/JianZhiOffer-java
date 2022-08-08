package jianzhiOffer;

import utils.TreeNode;

import java.util.*;

// 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

public class Offer32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        MyStack stack = new MyStack(root);
        List<List<Integer>> ans = new ArrayList<>();

        while(!stack.isEmpty()) {
            ArrayList<Integer> nodes = new ArrayList<>();
            while(!stack.isEmpty()) {
                nodes.add(stack.pop().val);
            }
            ans.add(nodes);
            stack.switchStack();
        }
        return ans;
    }

    class MyStack {
        private Stack<TreeNode> stack1;
        private Stack<TreeNode> stack2;
        private boolean isLevelOdd;

        MyStack(TreeNode node) {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            isLevelOdd = true;
            stack1.push(node);
        }

        void push(TreeNode element) {
            if (element == null) {
                return;
            }
            if (isLevelOdd) {
                stack2.push(element);
            } else {
                stack1.push(element);
            }
        }

        TreeNode pop() {
            if (isLevelOdd && !stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                push(node.left);
                push(node.right);
                return node;
            }
            if (!isLevelOdd && !stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                push(node.right);
                push(node.left);
                return node;
            }
            return null;
        }

        boolean isEmpty() {
            if (isLevelOdd) {
                return stack1.isEmpty();
            } else {
                return stack2.isEmpty();
            }
        }

        void switchStack() {
            isLevelOdd = !isLevelOdd;
        }
    }
}
