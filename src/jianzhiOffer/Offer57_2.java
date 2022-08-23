package jianzhiOffer;

// 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

import java.util.ArrayList;
import java.util.List;

// 双指针可以搜集全的原因是以每个数字为起点的数组都被尝试过了
public class Offer57_2 {
    private List<List<Integer>> ans;
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[0][0];
        }
        ans = new ArrayList<>();
        int small = 1;
        int big = 2;
        while (small < big) {
            int sum = (small + big) * (big - small + 1) / 2;
            if (sum < target) {
                big++;
            } else if (sum > target) {
                small++;
            } else {
                add(small, big);
                small++;
            }
        }

        int pairNum = ans.size();
        int[][] answer = new int[pairNum][];
        for (int i = 0; i < pairNum; i++) {
            List<Integer> array = ans.get(i);
            int len = array.size();
            int[] list = new int[len];
            for (int j = 0; j < len; j++) {
                list[j] = array.get(j);
            }
            answer[i] = list;
        }
        return answer;
    }

    private void add(int small, int big) {
        List<Integer> list = new ArrayList<>();
        for (int i = small; i <= big; i++) {
            list.add(i);
        }
        ans.add(list);
    }
}