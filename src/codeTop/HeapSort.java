package codeTop;

public class HeapSort {
    private int[] nums;

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        rebuild();
        swap(0, nums.length - 1);
        for (int treeLen = nums.length - 1; treeLen > 1; treeLen--) {
            sinkNode(0, treeLen);
            swap(0, treeLen - 1);
        }
        return nums;
    }

    // 将数组初始化成树，并把树重新构造成大顶堆的样子
    private void rebuild() {
        for (int node = findLastNotLeafNode(nums.length); node >= 0; node--) {
            sinkNode(node, nums.length);
        }
    }

    // 将该结点下沉，即往下交换之后，如果有孩子结点比自己大，则继续交换
    private void sinkNode(int node, int treeLen) {
        // 循环执行操作，当交换完大小之后，对于交换后的孩子结点判断是否需要继续交换
        while (node <= findLastNotLeafNode(treeLen)) {
            int leftIndex = getLeftChildIndex(node, treeLen);
            int rightIndex = getRightChildIndex(node, treeLen);
            // 左孩子比该节点和右节点大(和右节点相等时取左节点)
            if (leftIndex != -1 && nums[leftIndex] > nums[node] && (rightIndex == -1 || nums[leftIndex] >= nums[rightIndex]) ) {
                swap(node, leftIndex);
                node = leftIndex;
            }
            // 右孩子比该节点
            else if (rightIndex != -1 && nums[rightIndex] > nums[node] && (leftIndex == -1 || nums[rightIndex] > nums[leftIndex])) {
                swap(node, rightIndex);
                node = rightIndex;
            }
            // 当前节点最大，不需要交换，跳出循环
            else {
                break;
            }
        }
    }

    // 交换之后，将一个数上浮至它应该的位置上
    // 在这个阶段，交换之后不需要担心交换下去的节点破坏堆的结构，因为交换下去的值本来就是大值
    private void floatNode(int node) {
        while (node != 0) {
            int parentIndex = getParentIndex(node);
            if (nums[parentIndex] < nums[node]) {
                swap(parentIndex, node);
                node = parentIndex;
            } else {
                break;
            }
        }
    }

    private int findLastNotLeafNode(int treeLen) {
        return treeLen / 2 - 1;
    }

    private int getLeftChildIndex(int node, int treeLen) {
        int leftChild = node * 2 + 1;
        return leftChild < treeLen ? leftChild : -1;
    }

    private int getRightChildIndex(int node, int treeLen) {
        int rightChild = node * 2 + 2;
        return rightChild < treeLen ? rightChild : -1;
    }

    private int getParentIndex(int node) {
        if (node == 0) {
            return -1;
        }
        return (node - 1) / 2;
    }

    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
