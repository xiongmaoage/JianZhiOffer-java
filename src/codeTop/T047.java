package codeTop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T047 {
    private List<List<Integer>> ans;
    private List<Integer> current;
    private Map<Integer, Integer> count;
    private Map<Integer, Integer> used;
    private int len;

    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        count = new HashMap<>();
        used = new HashMap<>();
        current = new ArrayList<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        len = nums.length;
        permute(0);
        return ans;
    }

    private void permute(int pos) {
        if (pos == len) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int num : count.keySet()) {
            if (used.getOrDefault(num, 0) < count.get(num)) {
                current.add(num);
                used.put(num, used.getOrDefault(num, 0) + 1);
                permute(pos + 1);
                current.remove(current.size() - 1);
                used.put(num, used.get(num) - 1);
            }
        }
    }
}
