package jianzhiOffer;

// 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 判断输入的合法性
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 获得矩阵的维度
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 比较右上角的值，缩小范围
        int x = 0;
        int y = cols - 1;
        while (x < rows && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }
}
