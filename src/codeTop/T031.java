package codeTop;

import java.util.Stack;

public class T031 {
    private int[] nums;

    public void nextPermutation(int[] nums) {
        this.nums = nums;
        // 从右往左找到第一个非递增的数值
        int index;
        for (index = nums.length - 1; index > 0; index--) {
            if (nums[index - 1] < nums[index]) {
                break;
            }
        }
        // 如果全部是倒序
        if (index == 0) {
            reverse(0, nums.length);
            return;
        }
        // 对于一部分是倒序的情况，首先找到在倒序数组里比nums[index]大的最小元素
        int pos = find(index, nums.length, nums[index - 1]);
        // 交换第一个数字
        swap(index - 1, pos);
        // 把后面的内容倒序
        reverse(index, nums.length);
    }

    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private void reverse(int leftBound, int rightBound) {
        int left = leftBound, right = rightBound - 1;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
    }

    // 寻找到比target大的最小元素
    private int find(int leftBound, int rightBound, int target) {
        int left = leftBound, right = rightBound - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
