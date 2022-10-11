package codeTop;

public class T033 {
    private int[] nums;
    private int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return biSearch(0, nums.length);
    }

    private int biSearch(int left, int right) {
        if (right - left < 1) {
            return -1;
        }
        int mid = (left + right - 1) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right - 1] == target) {
            return right - 1;
        }
        if (nums[left] < nums[mid]) {   // 从Left到mid都在增长
            if(nums[left] < target && target < nums[mid]) {
                return biSearch(left + 1, mid);
            } else {
                return biSearch(mid + 1, right - 1);
            }
        } else {                        // 从mid到right都在增长
            if(nums[mid] < target && target < nums[right - 1]) {
                return biSearch(mid + 1, right - 1);
            } else {
                return biSearch(left + 1, mid);
            }
        }
    }
}
