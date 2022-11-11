package codeTop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class T496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 对nums2制作单调栈
        Stack<Integer> stack = new Stack<>();
        // 记录num2中每一个结点右侧比他大的最近结点
        Map<Integer, Integer> map = new HashMap<>();
        // 当想要右边的大值时，从右往左遍历数组，栈的方向为递减（这样栈顶才能是较小值）
        for (int index = nums2.length - 1; index >= 0; index--) {
            int element = nums2[index];
            // 将栈顶比当前元素小的值弹出来
            while (!stack.isEmpty() && stack.peek() < element) {
                stack.pop();
            }
            // 此时的栈顶元素比当前元素大，且栈顶元素左侧的元素都比栈顶元素小，所以该值即为所求
            map.put(element, stack.isEmpty() ? -1 : stack.peek());
            stack.push(element);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
