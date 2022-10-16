package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T022 {
    private char[] string;
    private List<String> ans;
    private int n;

    public List<String> generateParenthesis(int n) {
        this.string = new char[2 * n];
        this.n = n;
        ans = new ArrayList<>();
        generate(0, 0, 0);
        return ans;
    }

    private void generate(int index, int paired, int unpaired) {
        if (index == 2 * n) {
            ans.add(new String(string));
            return;
        }
        if (paired < n) {
            string[index] = '(';
            generate(index + 1, paired + 1, unpaired + 1);
        }
        if (unpaired > 0) {
            string[index] = ')';
            generate(index + 1, paired, unpaired - 1);
        }
    }
}
