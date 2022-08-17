package jianzhiOffer;

// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数

// 类比归并排序，精妙，看书去
public class Offer51 {
    private int[] nums;

    public int reversePairs(int[] nums) {
        this.nums = nums;
    }

    private int countAndSort(int left, int right) {
        if (left >= right) {
            System.out.println("wrong!");
            return -1;
        }
        if (right - left == 1) {
            return 0;
        }
        int mid = (left + right) / 2;
        int leftCount = countAndSort(left, mid + 1);
        int RightCount = countAndSort(mid, right);

        // 合并两个排序数组(left, mid)和(mid, right - 1)并统计逆序对的数量

    }
}
