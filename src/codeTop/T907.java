package codeTop;

import java.util.*;

class T907 {
    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        long ans = 0;
        // 单调栈，用来找到每个元素的最靠近的比他小的值，从左往右递增
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            // 找到所有以该节点为最小值的数组的数量。具体的，找到左侧第一个小于它的值，以及右侧第一个小于等于它的值
            // 针对每一个出栈的结点，此时的栈首就是其左边界，当前元素就是出栈元素的右边界
            while (!stack.isEmpty() && arr[stack.peek()] >= element) {
                int current = stack.pop();
                // 此时element小于等于current,栈顶元素严格小于current（因为相等时会被弹出栈）
                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;
                ans += (long) (current - left) * (right - current) * arr[current];
                ans %= MOD;
            }
            stack.push(i);
        }
        // 此时栈中的元素都没有右侧比他小的元素了，则他们的右侧最低点为右边界
        while (!stack.isEmpty()) {
            int current = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int right = arr.length;
            ans += (long) (current - left) * (right - current) * arr[current];
            ans %= MOD;
        }
        return (int)ans;
    }
}
