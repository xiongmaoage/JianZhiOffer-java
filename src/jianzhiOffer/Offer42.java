package jianzhiOffer;

// 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer42 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len < 1 || len > 100000) {
            return -1;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        for (int i = 1; i < len; i++) {
            if (dp.get(i - 1) <= 0) {
                dp.add(nums[i]);
            } else {
                dp.add(dp.get(i - 1) + nums[i]);
            }
        }
        return Collections.max(dp);
    }
}
