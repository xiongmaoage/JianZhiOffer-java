package jianzhiOffer;

public class Offer56 {
    public int[] singleNumbers(int[] nums) {
        // 通过异或获得两个数的异或结果
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        // 获得异或结果中最低位不一样的值（即一个数是0，一个数是1，所以异或结果也是1）
        int splitNum = 1;
        while ((splitNum & xor) == 0) {
            splitNum <<= 1;
        }
        // 接下来根据splitNum位的不同将数组分为两个部分，再分别抑或即可
        int xor1 = 0;
        int xor2 = 0;
        for (int num : nums) {
            if ((num & splitNum) != 0) {
                xor1 ^= num;
            } else {
                xor2 ^= num;
            }
        }
        int[] ans = new int[2];
        ans[0] = xor1;
        ans[1] = xor2;
        return ans;
    }
}
