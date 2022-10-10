package jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

// 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

public class Offer60 {
    public double[] dicesProbability(int n) {
        // 使用动态规划，记录当有n-1个骰子的时候，投出每一个值的可能情况的数量
        // 首先初始化n=1的情况
        SumRecorder last = new SumRecorder(1);
        for (int i = 1; i <= 6; i++) {
            last.add(i, 1);
        }
        // 循环中维护两个结果last和current，新的结果应该是在少一个骰子的基础上分别计算1-6得来的
        for (int diceNUm = 2; diceNUm <= n; diceNUm++) {
            SumRecorder current = new SumRecorder(diceNUm);
            // 分别计算每一个和的数量，和的大小应该为diceNum到6*diceNum
            for (int sum = diceNUm; sum <= 6 * diceNUm; sum++) {
                // 通过diceNum-1个骰子的情况来计算，分别计算当前骰子掷出1-6的情况
                for (int i = 1; i <= 6; i++) {
                    current.add(sum, last.get(sum - i));
                }
            }
            last = current;
        }

        // 此时last存储所有的点数的总数，可以依次算出概率
        double whole = Math.pow(6, n);
        double[] ans = new double[5 * n + 1];
        for (int sum = n; sum <= 6 * n; sum++) {
            ans[sum - n] = (last.get(sum)) / whole;
        }
        return ans;
    }

    class SumRecorder {
        // 存储掷出每一个点数的可能性的数组，从n开始
        private final long[] possibleList;
        // 目前有多少个骰子
        private final int n;

        SumRecorder(int n) {
            this.n = n;
            possibleList = new long[5 * n + 1];
        }

        void add(int sum, long times) {
            possibleList[sum - n] += times;
        }

        long get(int sum) {
            if (sum < n || sum - n > 5 * n) {
                return 0;
            }
            return possibleList[sum - n];
        }

        long[] getPossibleList() {
            return possibleList;
        }
    }

}
