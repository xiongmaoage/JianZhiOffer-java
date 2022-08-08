package jianzhiOffer;

// 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

public class Offer33 {
    private int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        this.postorder = postorder;
        return isPostorderRecursive(0, postorder.length);
    }

    private boolean isPostorderRecursive(int startIndex, int endIndex) {
        if (endIndex - startIndex <= 2) {
            return true;
        }
        int index = splitTree(startIndex, endIndex);
        if (index == -1) {
            return false;
        }
        if (!verifySplitResult(startIndex, endIndex, index)) {
            return false;
        }
        return isPostorderRecursive(startIndex, index) && isPostorderRecursive(index, endIndex - 1);
    }

    private int splitTree(int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return  -1;
        }
        int rootValue = postorder[endIndex - 1];
        int index;
        for (index = startIndex; index < endIndex; index++) {
            if (postorder[index] >= rootValue) {
                break;
            }
        }
        return index;
    }

    private boolean verifySplitResult(int startIndex, int endIndex, int splitIndex) {
        int rootValue = postorder[endIndex - 1];
        for (int i = startIndex; i < splitIndex; i++) {
            if (postorder[i] >= rootValue) {
                return false;
            }
        }
        for (int i = splitIndex; i < endIndex - 1; i++) {
            if (postorder[i] <= rootValue) {
                return false;
            }
        }
        return true;
    }
}
