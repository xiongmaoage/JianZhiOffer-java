package jianzhiOffer;

//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

// 注意如何分析问题，注意如何确定停止条件
// 注意退化到最后一圈的情况，任何复制粘贴的时候都要注意
public class Offer29 {
    private int rows;
    private int cols;
    private int[][] matrix;
    private int[] order;
    private int index = 0;

    public int[] spiralOrder(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) {
            return new int[0];
        }
        cols = matrix[0].length;
        if (cols == 0) {
            return new int[0];
        }
        this.matrix = matrix;
        this.order = new int[rows * cols];

        int start = 0;
        while (2 * start < rows && 2 * start < cols) {
            printCircle(start);
            start++;
        }
        return this.order;
    }

    private void printCircle(int start) {
        // 计算四个角
        int left = start;
        int right = cols - start - 1;
        int up = start;
        int bottom = rows - start - 1;
        // 打印一行
        for (int i = left; i < right; i++) {
            print(matrix[up][i]);
        }
        // 打印一列
        for (int i = up; i < bottom; i++) {
            print(matrix[i][right]);
        }
        // 处理退化的问题
        if (up == bottom || left == right) {
            print(matrix[bottom][right]);
            return;
        }
        // 打印一行
        for (int i = right; i > left; i--) {
            print(matrix[bottom][i]);
        }
        // 打印一列
        for (int i = bottom; i > up; i--) {
            print(matrix[i][left]);
        }
    }

    private void print(int number) {
        this.order[index] = number;
        index++;
    }
}
