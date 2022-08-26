package jianzhiOffer;

// 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14


import java.util.Arrays;

// 注意4和6之间只需要一张5，所以dist是num - 1
public class Offer61 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int jokerNum = 0;
        // 统计joker的数量
        int i = 0;
        while (nums[i] == 0) {
            jokerNum++;
            i++;
        }
        i++;
        // 从joker后面开始，统计组成顺子需要的数量，从jokerNum中减，其中如果有对子直接返回false
        while(i < 5) {
            int dist = nums[i] - nums[i - 1] - 1;
            if (dist < 0 || dist > jokerNum) {
                return false;
            }
            jokerNum -= dist;
            i++;
        }
        return true;
    }
}
