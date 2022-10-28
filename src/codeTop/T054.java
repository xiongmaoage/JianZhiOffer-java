package codeTop;

import java.util.ArrayList;
import java.util.List;

public class T054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int upBound = 0, leftBound = 0;
        int bottomBound = matrix.length - 1;
        int rightBound = matrix[0].length - 1;
        List<Integer> ans = new ArrayList<>();
        int direction = 0;
        while (upBound <= bottomBound && leftBound <= rightBound) {
            // 向右走
            if (direction % 4 == 0) {
                for (int col = leftBound; col <= rightBound; col++) {
                    ans.add(matrix[upBound][col]);
                }
                upBound++;
            }
            // 向下走
            else if (direction % 4 == 1) {
                for (int row = upBound; row <= bottomBound; row++) {
                    ans.add(matrix[row][rightBound]);
                }
                rightBound--;
            }
            // 向左走
            else if (direction % 4 == 2) {
                for (int col = rightBound; col >= leftBound; col--) {
                    ans.add(matrix[bottomBound][col]);
                }
                bottomBound--;
            }
            // 向上走
            else {
                for (int row = bottomBound; row >= upBound; row--) {
                    ans.add(matrix[row][leftBound]);
                }
                leftBound++;
            }
            direction++;
        }
        return ans;
    }
}
