package jianzhiOffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

// 使用一个数据结构，只存储可能为最大值的值。即，一个数前面不能有比他小的数字
// 每次添加一个数字时，需要从队列尾部删除比当前数字小的数，并删除队首可能出队的数

public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        // 双头队列
        Deque<Integer> deque = new LinkedList<>();

        // 加入前k个数，组成第一个滑动窗口，每一个循环加入一个数
        for (int i = 0; i < k; i++) {
            // 删除队尾比目前的数要小的数
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 加入当前的数
            deque.offerLast(i);
        }
        // 加入滑动窗口刚出现时的最大值，即队首元素
        list.add(nums[deque.peekFirst()]);

        // 窗口继续挪动，使用i表示当前窗口的最后一个数，则当前窗口的第一个数为i-k+1
        for (int i = k; i < nums.length; i++) {
            // 删除队尾比目前的数要小的数
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 加入当前的数
            deque.offerLast(i);
            // 如果队首元素出了窗口，需要删除队首元素
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            list.add(nums[deque.peekFirst()]);
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
