package codeTop;

public class T189 {
    private int[] nums;

    public void rotate(int[] nums, int k) {
        this.nums = nums;
        k = k % nums.length;
        reverse(0, nums.length);
        reverse(0, k);
        reverse(k, nums.length);
    }

    private void reverse(int leftBound, int rightBound) {
        int left = leftBound, right = rightBound - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
