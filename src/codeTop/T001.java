package codeTop;

import java.util.*;

public class T001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                map.get(num).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(num, list);
            }
        }
        if (target % 2 == 0 && map.containsKey(target / 2) && map.get(target / 2).size() > 1) {
            List<Integer> ans = map.get(target / 2);
            return new int[]{ ans.get(0), ans.get(1) };
        }
        for (int n1 : map.keySet()) {
            int n2 = target - n1;
            if (map.containsKey(n2)) {
                return new int[]{ map.get(n1).get(0), map.get(n2).get(0) };
            }
        }
        return new int[0];
    }
}
