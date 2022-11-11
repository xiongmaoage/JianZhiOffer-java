package codeTop;

import java.util.Arrays;

public class T079 {
    private char[][] board;
    private boolean[][] used;
    int rows;
    int cols;
    boolean ans;
    String target;
    int len;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        rows = board.length;
        cols = board[0].length;
        used = new boolean[rows][cols];
        ans = false;
        target = word;
        len = target.length();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    dfs(i, j, 1);
                    used[i][j] = false;
                    if (ans) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void dfs(int row, int col, int pos) {
        if (pos == len) {
            ans = true;
            return;
        }
        if (row > 0 && board[row - 1][col] == target.charAt(pos) && !used[row - 1][col]) {
            used[row - 1][col] = true;
            dfs(row - 1, col, pos + 1);
            used[row - 1][col] = false;
        }
        if (ans) {
            return;
        }
        if (row < rows - 1 && board[row + 1][col] == target.charAt(pos) && !used[row + 1][col]) {
            used[row + 1][col] = true;
            dfs(row + 1, col, pos + 1);
            used[row + 1][col] = false;
        }
        if (ans) {
            return;
        }
        if (col > 0 && board[row][col - 1] == target.charAt(pos) && !used[row][col - 1]) {
            used[row][col - 1] = true;
            dfs(row, col - 1, pos + 1);
            used[row][col - 1] = false;
        }
        if (ans) {
            return;
        }
        if (col < cols - 1 && board[row][col + 1] == target.charAt(pos) && !used[row][col + 1]) {
            used[row][col + 1] = true;
            dfs(row, col + 1, pos + 1);
            used[row][col + 1] = false;
        }
    }
}
