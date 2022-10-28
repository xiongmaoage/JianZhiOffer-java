package codeTop;

import utils.TreeNode;

import java.util.Stack;

public class T173 {
    public static void main(String[] args) {
        BSTIterator iterator = new BSTIterator(new TreeNode(new Integer[]{3, 1, 4, null, 2}));
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


class BSTIterator {
    private final TreeNode root;
    private TreeNode pointer;
    private TreeNode last;
    // 保存到Pointer的路径（不包括pointer)
    private Stack<TreeNode> path;

    public BSTIterator(TreeNode root) {
        this.root = root;
        last = root;
        while (last.right!= null) {
            last = last.right;
        }
    }

    public int next() {
        if (pointer == null) {
            findFirstNode();
        } else if (pointer.right != null) {
            path.push(pointer);
            pointer = pointer.right;
            while (pointer.left != null) {
                path.push(pointer);
                pointer = pointer.left;
            }
        } else {
            TreeNode father = path.pop();
                while (pointer == father.right) {
                    pointer = father;
                    father = path.pop();
                }
                pointer = father;
            }
        return pointer.val;
    }

    public boolean hasNext() {
        return pointer != last;
    }

    private void findFirstNode() {
        path = new Stack<>();
        TreeNode node = root;
        while (node.left != null) {
            path.push(node);
            node = node.left;
        }
        pointer = node;
    }
}
