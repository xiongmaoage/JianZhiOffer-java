package codeTop;

import java.util.Arrays;

public class T974 {
    public int subarraysDivByK(int[] nums, int k) {
        // remainders[i]保留以i为余数的从头到当前值的子数组和有多少个。计算以当前数字为最后数字时，只需要找到前面同余数的即可
        int[] remainders = new int[k];
        Arrays.fill(remainders, 0);
        int ans = 0;
        int sum = 0;
        remainders[0] = 1;
        for (int num : nums) {
            sum = (sum + num) % k;
            sum = sum < 0 ? sum + k : sum;
            ans += remainders[sum];
            remainders[sum]++;
        }
        return ans;
    }
}
