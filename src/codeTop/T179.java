package codeTop;

import java.util.Arrays;
import java.util.Comparator;

public class T179 {
    public String largestNumber(int[] nums) {
        Integer[] numbers = new Integer[nums.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers, (n1, n2) -> {
            String str1 = n1.toString();
            String str2 = n2.toString();
            String combine1 = str1 +str2;
            String combine2 = str2 + str1;
            return combine2.compareTo(combine1);
        });
        // 如果最大值是0，则代表数组内容全是0，返回0（唯一前导0的可能性）
        if (numbers[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (Integer number : numbers) {
            ans.append(number.toString());
        }
        return ans.toString();
    }
}
