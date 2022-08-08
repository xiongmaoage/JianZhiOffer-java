package jianzhiOffer;

// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//
// 错误位置：没有注意到元素都相同的情况，方法没有理解透彻
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                // 如果在交换过程中找到了重复的，则输出
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                // 交换
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
