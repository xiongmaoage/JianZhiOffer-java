package codeTop;

public class T215 {
    private int[] nums;

    public int findKthLargest(int[] nums, int k) {
        if (k < 0 || k > nums.length) {
            System.out.println("error");
            return -1;
        }
        this.nums = nums;
        k--;
        int start = 0, end = nums.length;
        while (true) {
            int splitPos = partition(start, end);
            if (splitPos == k) {
                return nums[splitPos];
            } else if (splitPos < k) {
                start = splitPos + 1;
            } else {
                end = splitPos;
            }
        }
    }

    // 以最后一个元素为轴分割，并且返回第一个元素最终的位置
    private int partition(int start, int end) {
        if (end <= start) {
            System.out.println("error! " + start + " " + end);
        }
        int pixel = nums[end - 1];
        int replacePos = start - 1;
        for (int i = start; i < end - 1; i++) {
            if (nums[i] > pixel) {
                replacePos++;
                if (replacePos < i) {
                    swap(replacePos, i);
                }
            }
        }
        replacePos++;
        swap(end - 1, replacePos);
        return replacePos;
    }

    private void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= nums.length || index2 < 0 || index2 > nums.length) {
            System.out.println("error in swap!");
            return;
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
