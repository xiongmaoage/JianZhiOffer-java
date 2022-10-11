package codeTop;

import java.util.Random;

public class QuickSort {
    private int nums[];

    public int[] sortArray(int[] nums) {
        this.nums = nums;
        quickSort(0, nums.length);
        return nums;
    }

    private void quickSort(int start, int end) {
        if (start + 1 >= end) {
            return;
        }
        int pixelPos = partition(start, end);
        if (pixelPos - start > 1) {
            quickSort(start, pixelPos);
        }
        if (end - pixelPos > 2) {
            quickSort(pixelPos + 1, end);
        }
    }

    private int partition(int start, int end) {
        if (start >= end) {
            System.out.println("error in partition");
            return -1;
        }
        // 随机
        int randomIndex = new Random().nextInt(end - start) + start;
        swap(randomIndex, start);
        int pixel = nums[start];
        int finish = start;
        for (int i = start + 1; i < end; i++) {
            if (nums[i] < pixel) {
                finish++;
                if (i != finish) {
                    swap(finish, i);
                }
            }
        }
        swap(finish, start);
        return finish;
    }

    private void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= nums.length || index2 < 0 || index2 >= nums.length) {
            System.out.println("error in swap");
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
