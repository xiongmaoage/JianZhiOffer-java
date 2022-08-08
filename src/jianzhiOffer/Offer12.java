package jianzhiOffer;

import java.util.Set;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
public class Offer12 {
    private char[][] board;
    private String word;
    private boolean[][] used;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        this.used = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                used[i][j] = false;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (explore(i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean explore(int row, int col, int pos) {
        if (pos == word.length()) {
            return true;
        }
        used[row][col] = true;
        // 左边(row, col - 1)
        if (col != 0 && !used[row][col - 1] && word.charAt(pos) == board[row][col - 1]) {
            if (explore(row, col - 1, pos + 1)) {
                return true;
            }
        }
        // 右边(row, col + 1)
        if (col != cols - 1 && !used[row][col + 1] && word.charAt(pos) == board[row][col + 1]) {
            if (explore(row, col + 1, pos + 1)) {
                return true;
            }
        }
        // 上边(row - 1, col)
        if (row != 0 && !used[row - 1][col] && word.charAt(pos) == board[row - 1][col]) {
            if (explore(row - 1, col, pos + 1)) {
                return true;
            }
        }
        // 下边(row + 1, col)
        if (row != rows - 1 && !used[row + 1][col] && word.charAt(pos) == board[row + 1][col]) {
            if (explore(row + 1, col, pos + 1)) {
                return true;
            }
        }
        used[row][col] = false;
        return false;
    }
}
