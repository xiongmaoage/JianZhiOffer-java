package jianzhiOffer;

// 统计一个数字在排序数组中出现的次数。

public class Offer53_1 {
    private int[] nums;
    private int target;

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        this.nums = nums;
        this.target = target;
        int leftIndex = searchLeft();
        int rightIndex = searchRight();
        return rightIndex - leftIndex + 1;
    }

    // 找到最左侧出现的位置
    private int searchLeft() {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 找到最右侧出现的位置
    private int searchRight() {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
