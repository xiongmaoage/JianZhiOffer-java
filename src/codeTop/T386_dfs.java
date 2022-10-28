package codeTop;

import java.util.ArrayList;
import java.util.List;

public class T386_dfs {
    private List<Integer> ans;
    private int upBound;

    public List<Integer> lexicalOrder(int n) {
        upBound = n;
        ans = new ArrayList<>();
        for (int first = 1; first < 10; first++) {
            dfs(first);
        }
        return ans;
    }

    private void dfs(int number) {
        if (number > upBound) {
            return;
        }
        ans.add(number);
        number *= 10;
        for (int i = 0; i < 10; i++) {
            dfs(number + i);
        }
    }
}
