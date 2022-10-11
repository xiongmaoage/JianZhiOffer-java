package codeTop;

import java.util.*;

public class T015 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();    // 记录每个数字出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int n1 : map.keySet()) {
            for (int n2 : map.keySet()) {
                int n3 = -n1 - n2;
                // 只需要递增排列且三个数都存在的组合
                if (!(n1 <= n2 && n2 <= n3) || !map.containsKey(n3)) {
                    continue;
                }

                if (n1 == 0) {                              // 如果三个数都一样
                    if (map.get(n1) >= 3) {
                        ans.add(Arrays.asList(0, 0, 0));
                    }
                } else if (n1 == n2 || n2 == n3) {          // 如果有两个数一样
                    if (map.get(n2) >= 2) {
                        ans.add(Arrays.asList(n1, n2, n3));
                    }
                } else {                                    // 三个数都不一样
                    ans.add(Arrays.asList(n1, n2, n3));
                }
            }
        }
        return ans;
    }
}
