package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T046 {
    private int[] numbers;
    private boolean[] used;
    private List<Integer> current;
    private List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        current = new ArrayList<>();
        numbers = nums;
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        traverse(0);
        return ans;
    }

    private void traverse(int index) {
        if (index == numbers.length) {
            ans.add(new ArrayList<>(current));
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) {
                current.add(numbers[i]);
                used[i] = true;
                traverse(index + 1);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
