package codeTop;

public class T053 {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int lastSum = 0;
        for (int num : nums) {
            if (lastSum <= 0) {
                lastSum = num;
            } else {
                lastSum += num;
            }
            maxSum = Math.max(maxSum, lastSum);
        }
        return maxSum;
    }
}
