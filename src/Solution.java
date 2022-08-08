class Solution {
    private long sum = 0;
    private int[] nums;

    public long subArrayRanges(int[] nums) {
        this.nums = nums;
        for (int i = 0; i < nums.length - 1; i++) {
            this.calculate(i);
        }
        return sum;
    }

    private void calculate(int startIndex) {
        int min = nums[startIndex];
        int max = nums[startIndex];
        for (int i = startIndex + 1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            sum += max - min;
        }
    }
}