package jianzhiOffer;

// 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数

// 类比归并排序，精妙，看书去
public class Offer51 {
    private int[] nums;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        this.nums = nums;
        return countAndSort(0, nums.length);
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
        int leftCount = countAndSort(left, mid);
        int rightCount = countAndSort(mid, right);

        // 合并两个排序数组(left, mid)和(mid, right)并统计逆序对的数量
        int mergeCount = 0;
        // 临时数组，存储排序后的(left, right)，方便merge之后回填
        int[] tempArray = new int[right - left];
        System.arraycopy(nums, left, tempArray, 0, right - left);
        // 两个指针，分别标记新数组的左侧最大值和右侧最大值，还有一个指针标记目前填写的位置
        int leftPointer = mid - left - 1;
        int rightPointer = right - left - 1;
        int numPointer = right - 1;
        // 依次往回填
        while (leftPointer >= 0 && rightPointer >= mid - left) {
            if (tempArray[leftPointer] <= tempArray[rightPointer]) {
                nums[numPointer] = tempArray[rightPointer];
                rightPointer--;
            } else {    // 左侧的最大值大于右侧的最大值，说明左侧的最大值和右侧的所有内容构成逆序对
                nums[numPointer] = tempArray[leftPointer];
                mergeCount += rightPointer - (mid - 1 - left);  // 括号里为左侧最后的位置在新数组中的下标
                leftPointer--;
            }
            numPointer--;
        }
        if (leftPointer >= 0) {
            // 复制左侧的剩余值
            System.arraycopy(tempArray, 0, nums, left, leftPointer + 1);
        } else {
            // 复制右侧的剩余值
            System.arraycopy(tempArray, mid - left, nums, left, rightPointer - (mid - left) + 1);
        }
        return leftCount + rightCount + mergeCount;
    }
}
