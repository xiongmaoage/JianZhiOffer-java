package jianzhiOffer;

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。

public class Offer21 {
    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < end && isOdd(nums[start])) {
                start++;
            }
            if (start == end) {
                break;
            }
            while (start < end && !isOdd(nums[end])) {
                end--;
            }
            if (start == end) {
                break;
            }
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        return nums;
    }

    private boolean isOdd(int number) {
        return number % 2 == 1;
    }
}
