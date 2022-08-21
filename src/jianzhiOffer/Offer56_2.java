package jianzhiOffer;

// 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字

public class Offer56_2 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & 1) != 0) {   // 如果第i位是1
                    bits[i]++;
                }
                num = num >>> 1;    // 无符号右移
            }
        }
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            ans = ans << 1;
            if (bits[i] % 3 == 1) {
                ans++;
            }
        }
        return ans;
    }
}
