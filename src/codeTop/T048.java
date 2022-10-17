package codeTop;

public class T048 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) {
            return;
        }
        if (matrix[0].length != len) {
            System.out.println("error");
            return;
        }
        for (int row = 0; row < len / 2; row++) {
            for (int col = 0; col < (len + 1) / 2; col++) {
                rotateElement(matrix, row, col);
            }
        }
    }

    private void rotateElement(int[][] matrix, int row, int col) {
        int len = matrix.length;
        int temp = matrix[row][col];
        for (int i = 0; i < 3; i++) {
            // 获得旋转之前的坐标
            int lastRow = len - 1 - col;
            int lastCol = row;
            // 将当前坐标的值替换为下一时刻的目标值
            matrix[row][col] = matrix[lastRow][lastCol];
            // 更新坐标值
            row = lastRow;
            col = lastCol;
        }
        matrix[row][col] = temp;
    }
}
