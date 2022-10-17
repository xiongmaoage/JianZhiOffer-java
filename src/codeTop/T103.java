package codeTop;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean isLeft = true;
        stack1.push(root);
        while (!stack1.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                list.add(node.val);
                if (isLeft) {
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                }
            }
            ans.add(list);
            Stack<TreeNode> stack = stack1;
            stack1 = stack2;
            stack2 = stack;
            isLeft = !isLeft;
        }
        return ans;
    }
}
