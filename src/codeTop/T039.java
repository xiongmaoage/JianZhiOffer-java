package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T039 {
    private int[] candidates;
    private List<List<Integer>> ans;
    private List<Integer> current;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        Arrays.sort(candidates);
        ans = new ArrayList<>();
        current = new ArrayList<>();
        traceback(0, target);
        return ans;
    }

    private void traceback(int startIndex, int target) {
        for (int i = startIndex; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            } else if (target == candidates[i]) {   // 正好相等，则可以放入ans
                current.add(target);
                ans.add(new ArrayList<>(current));
                current.remove(current.size() - 1);
                return;
            }
            current.add(candidates[i]);
            traceback(i, target - candidates[i]);
            current.remove(current.size() - 1);
        }
    }
}
