package jianzhiOffer;

// 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int smallIndex = 0;
        int largeIndex = nums.length - 1;
        while (smallIndex <= largeIndex) {
            if (nums[smallIndex] + nums[largeIndex] < target) {
                smallIndex++;
            } else if (nums[smallIndex] + nums[largeIndex] > target) {
                largeIndex--;
            } else {
                break;
            }
        }
        return new int[]{nums[smallIndex], nums[largeIndex]};

    }
}
