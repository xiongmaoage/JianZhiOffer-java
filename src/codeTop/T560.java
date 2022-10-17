package codeTop;

import java.util.HashMap;
import java.util.Map;

public class T560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sum2Times = new HashMap<>();
        sum2Times.put(0, 1);
        int times = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            // 如果之前有和为sum-k的值，则从该值开始直到当前的所有数的和即为k
            times += sum2Times.getOrDefault(sum - k, 0);
            sum2Times.put(sum, sum2Times.getOrDefault(sum, 0) + 1);
        }
        return times;
    }
}
