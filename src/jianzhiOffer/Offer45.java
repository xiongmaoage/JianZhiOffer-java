package jianzhiOffer;

// 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

// 记住Arrays.sort的用法
import java.util.Arrays;
import java.util.Comparator;

public class Offer45 {
    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer num1, Integer num2) {
            String str1 = Integer.toString(num1).concat(Integer.toString(num2));
            String str2 = Integer.toString(num2).concat(Integer.toString(num1));
            return str1.compareTo(str2);
        }
    }

    public String minNumber(int[] nums) {
        MyComparator cmp = new MyComparator();
        Integer[] numbers = transferIntArrayToIntegerArray(nums);
        Arrays.sort(numbers, cmp);
        String ans = "";
        for (Integer number : numbers) {
            ans = ans.concat(Integer.toString(number));
        }
        return ans;
    }

    private Integer[] transferIntArrayToIntegerArray(int[] nums) {
        int len = nums.length;
        Integer[] numbers = new Integer[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = nums[i];
        }
        return numbers;
    }
}
