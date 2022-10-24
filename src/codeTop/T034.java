package codeTop;

public class T034 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        // 寻找左边界
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int leftBound = left;
        if (leftBound >= nums.length || nums[leftBound] != target) {
            return new int[]{-1, -1};
        }
        // 寻找右边界
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int rightBound = right;
        return new int[]{leftBound, rightBound};
    }
}
