package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview08_12 {
    // 值为0代表可以放皇后，值为1代表放上了皇后，值为负数代表这个地方已经不能放皇后了
    private int[][] chessBoard;
    private int size;
    private List<List<String>> ans;

    public List<List<String>> solveNQueens(int n) {
        size = n;
        chessBoard = new int[n][n];
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(chessBoard[i], 0);
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                updateBoard(row, col, true);
                find(row, col, 1);
                updateBoard(row, col, false);
            }
        }
        return ans;
    }

    private void find(int row, int col, int num) {
        if (num == size) {
            print();
            return;
        }
        for (int i = row; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == row && j <= col) {
                    continue;
                }
                if (chessBoard[i][j] >= 0) {
                    updateBoard(i, j, true);
                    find(i, j, num + 1);
                    updateBoard(i, j, false);
                }
            }
        }
    }

    // isAdd为true代表是下棋，是false代表回溯
    private void updateBoard(int row, int col, boolean isAdd) {
        // 行、列
        for (int i = 0; i < size; i++) {
            if (isAdd) {
                chessBoard[row][i]--;
                chessBoard[i][col]--;
            } else {
                chessBoard[row][i]++;
                chessBoard[i][col]++;
            }
        }
        // 对角线
        // 左上
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            chessBoard[i--][j--] -= isAdd ? 1 : -1;
        }
        // 右上
        i = row; j = col;
        while (i >= 0 && j < size) {
            chessBoard[i--][j++] -= isAdd ? 1 : -1;
        }
        // 左下
        i = row; j = col;
        while (i < size && j >= 0) {
            chessBoard[i++][j--] -= isAdd ? 1 : -1;
        }
        // 右下
        i = row; j = col;
        while (i < size  && j < size) {
            chessBoard[i++][j++] -= isAdd ? 1 : -1;
        }
        // 重置当前节点
        chessBoard[row][col] = isAdd ? 1 : 0;
    }

    private void print() {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < size; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < size; col++) {
                sb.append(chessBoard[row][col] > 0 ? "Q" : ".");
            }
            board.add(sb.toString());
        }
        ans.add(board);
    }
}
