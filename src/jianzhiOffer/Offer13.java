package jianzhiOffer;

// 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格
// （不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
// 请问该机器人能够到达多少个格子？

public class Offer13 {
    private boolean[][] visited;
    private int count = 0;
    private int rows;
    private int cols;
    private int k;

    public int movingCount(int m, int n, int k) {
        if (n < 1 || n > 100 || m < 1 || m > 100 || k < 0 || k > 20) {
            return -1;
        }
        this.rows = m;
        this.cols = n;
        this.visited = new boolean[m][n];
        this.k = k;
        move(0, 0);
        return count;
    }

    private void move(int x, int y) {
        // 越界
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return;
        }
        // 已经判断过了
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (getNumSum(x) + getNumSum(y) > k) {
            return;
        }
        count++;
        // 向上
        if (x != 0) {
            move(x - 1, y);
        }
        // 向下
        if (x != rows - 1) {
            move(x + 1, y);
        }
        // 向左
        if (y != 0) {
            move(x, y - 1);
        }
        // 向右
        if (y != cols - 1) {
            move(x, y + 1);
        }

    }

    private int getNumSum(int num) {
        int ans = 0;
        while (num != 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}
