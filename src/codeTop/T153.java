package codeTop;

public class T153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // 注意终止条件，终止条件不是范围缩小，而是左侧大于右侧。如果左侧小于右侧，则最小值为左侧
        while (nums[left] > nums[right]) {
            // 由于缩短了距离，所以需要考虑当长度等于2时的情况，单独讨论
            if (right - left == 1) {
                left = right;
                break;
            }
            int mid = (left + right) / 2;
            // 如果左中右都相等，则需要遍历找到数组最小值
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                int min = left;
                for (int i = left; i <= right; i++) {
                    if (nums[i] < nums[min]) {
                        min = i;
                    }
                }
                left = min;
                break;
            }
            // 因为有左侧大于右侧的前提，所以这两个情况就可以覆盖全部情况
            // 如果左边小于中间，说明左半边是递增序列，可以排除
            // 如果中间小于右边，说明右半边是递增序列，可以排除
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else if (nums[mid] <= nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }
}
