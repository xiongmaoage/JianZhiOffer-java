package codeTop;

import java.util.Deque;
import java.util.LinkedList;

public class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列保存窗口中可能的最大值的下标
        // 当新来一个值时，如果比当前队尾的大，则当前队尾的值不再可能是最大值，将其替换掉；否则将新值加到队尾
        // 也就是说，在队列中的元素是个单调递减的序列
        Deque<Integer> potentialMax = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        int ansIndex = 0;

        // 初始化queue，即将前k个元素放入queue中
        for (int i = 0; i < k; i++) {
            // 判断和队尾元素的大小关系，如果大于等于队尾元素则替换掉队尾元素
            while (!potentialMax.isEmpty() && nums[i] >= nums[potentialMax.peekLast()]) {
                potentialMax.pollLast();
            }
            potentialMax.offerLast(i);
        }
        ans[ansIndex++] = nums[potentialMax.peekFirst()];

        // 移动滑动窗口，分为三步：第一步：去掉左侧值，第二步：删除队尾值，第三步：将新值加到队尾
        for (int i = k; i < nums.length; i++) {
            int delete = i - k;
            // 去掉左侧值
            if (!potentialMax.isEmpty() && delete == potentialMax.peekFirst()) {
                potentialMax.pollFirst();
            }
            // 判断和队尾元素的大小关系，如果大于等于队尾元素则替换掉队尾元素
            while (!potentialMax.isEmpty() && nums[i] >= potentialMax.peekLast()) {
                potentialMax.pollLast();
            }
            // 放入当前值
            potentialMax.offerLast(i);
            // 保存最大值
            ans[ansIndex++] = nums[potentialMax.peekFirst()];
        }
        return ans;
    }
}
