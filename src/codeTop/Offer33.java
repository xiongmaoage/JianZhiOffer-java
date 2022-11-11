package codeTop;

public class Offer33 {
    private int[] postorder;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        return isPostorderRecursive(0, postorder.length);
    }

    private boolean isPostorderRecursive(int leftBound, int rightBound) {
        // null和单独结点
        if (leftBound == rightBound || leftBound + 1 == rightBound) {
            return true;
        }
        int splitIndex = findSplit(leftBound, rightBound);
        if (splitIndex < 0) {
            return false;
        }
        return isPostorderRecursive(leftBound, splitIndex)
                && isPostorderRecursive(splitIndex, rightBound - 1);
    }

    // 返回两棵子树的分割点，具体值为右子树的第一个数。如果该数组无法分割，则返回-1
    private int findSplit(int leftBound, int rightBound) {
        if (leftBound > rightBound) {
            System.out.println("error");
            return -2;
        }
        int pos = rightBound - 1;
        int pixel = postorder[rightBound - 1];
        while (leftBound <= pos && postorder[pos] >= pixel) {
            pos--;
        }
        pos++;
        // 检查左子树没有比当前节点大的值
        for (int i = leftBound; i < pos; i++) {
            if (postorder[i] > pixel) {
                return -1;
            }
        }
        return pos;
    }
}
