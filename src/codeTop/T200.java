package codeTop;

public class T200 {
    private char[][] grid;
    private int islandNum;
    private int rows;
    private int cols;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.islandNum = 0;
        this.rows = grid.length;
        this.cols = grid[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    islandNum++;
                    search(row, col);
                }
            }
        }
        return islandNum;
    }

    private void search(int row, int col) {
        grid[row][col] = '0';
        if (row != 0 && grid[row - 1][col] == '1') {
            search(row - 1, col);
        }
        if (col != 0 && grid[row][col - 1] == '1') {
            search(row, col - 1);
        }
        if (row != rows - 1 && grid[row + 1][col] == '1') {
            search(row + 1, col);
        }
        if (col != cols - 1 && grid[row][col + 1] == '1') {
            search(row, col + 1);
        }
    }
}
