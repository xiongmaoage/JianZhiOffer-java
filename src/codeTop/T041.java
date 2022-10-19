package codeTop;

public class T041 {
    public int firstMissingPositive(int[] nums) {
        // 通过交换，将每一个值交换到其对应的下标的位置上。之后再遍历一遍数组，不等于对应下标的最小的数即为所求
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int target = nums[i] - 1;
            // 如果该位置的值不在范围内，则忽略不管
            // 否则一直替换，将其替换到target的位置上，除非target本来的位置就是对的
            while (target >= 0 && target < len) {
                // 如果target的位置本来就是对的，则不用替换，直接跳过
                if (nums[target] == target + 1) {
                    break;
                }
                int temp = nums[target];
                nums[target] = nums[i];
                nums[i] = temp;
                target = nums[i] - 1;
            }
        }
        // 从头遍历，如果该位置的数不对，证明那个位置的数丢了
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
