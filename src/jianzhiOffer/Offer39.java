package jianzhiOffer;

// 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

// 充分利用数组中数字较多的特性，第一种方式，可以找到数组中位数，一定是重复的数字
// 第二种方式，通过不一样就交换的方式，也可以实现

// 循环时注意数组越界
public class Offer39 {
    private int[] nums;

    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len < 1 || len > 50000) {
            return -1;
        }
        this.nums = nums;

        int mid = len / 2;
        int left = 0;
        int right = len;
        int index = partition(0, len);
        while (index != mid) {
            if (index < mid) {
                left = index + 1;
            } else {
                right = index;
            }
            if (left == right) {
                index = left;
                break;
            }
            index = partition(left, right);
        }
        return nums[index];
    }

    // 以范围内最左边的数为轴，将轴左边放置所有比轴小的数，右边放置比他大的数，并返回轴最终的位置
    private int partition(int left, int right) {
        if (left >= right) {
            System.out.println("wrong!");
            return -1;
        }
        int pixel = nums[left];
        int pSmall = left;
        int pLarge = right - 1;
        while (pSmall < pLarge) {
            while (pSmall < right && nums[pSmall] <= pixel) {
                pSmall++;
            }
            while (pSmall > left && nums[pLarge] > pixel) {
                pLarge--;
            }
            if (pSmall < pLarge) {
                swap(pSmall, pLarge);
            }
        }
        swap(left, pLarge);
        return pLarge;
    }

    private void swap(int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
