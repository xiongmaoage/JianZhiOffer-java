package codeTop;

import java.util.*;

public class T040 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    Map<Integer, Integer> appearTimes;
    Integer[] sortedCandidate;
    int target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        // 统计出现次数
        appearTimes = new HashMap<>();
        for (int candidate : candidates) {
            appearTimes.put(candidate, appearTimes.getOrDefault(candidate, 0) + 1);
        }
        // 对数组大小进行排序
        sortedCandidate = appearTimes.keySet().toArray(new Integer[0]);
        Arrays.sort(sortedCandidate);
        dfs(0, 0);
        return ans;
    }

    private void dfs(int sum, int index) {
        if (index == sortedCandidate.length) {
            return;
        }
        int candidate = sortedCandidate[index];
        int times = appearTimes.get(candidate);
        dfs(sum, index + 1);
        int num;
        for (num = 0; num < times; num++) {
            sum += candidate;
            current.add(candidate);
            if (sum >= target) {
                if (sum == target) {
                    ans.add(new ArrayList<>(current));
                }
                // 将结点删掉并返回
                for (int i = 0; i <= num; i++) {
                    current.remove(current.size() - 1);
                }
                return;
            } else {
                dfs(sum, index + 1);
            }
        }
        for (int i = 0; i < times; i++) {
            current.remove(current.size() - 1);
        }
    }
}
