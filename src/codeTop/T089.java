package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T089 {
    private boolean[] number;
    private int binaryLen;
    private List<Integer> ans;

    public List<Integer> grayCode(int n) {
        number = new boolean[n];
        Arrays.fill(number, false);
        binaryLen = n;
        ans = new ArrayList<>();
        find(0);
        return ans;
    }

    private void find(int pos) {
        if (pos == binaryLen) {
            ans.add(turnToNumber());
            return;
        }
        find(pos + 1);
        number[pos] = ! number[pos];
        find(pos + 1);
    }

    private int turnToNumber() {
        int number = 0;
        for (int i = 0; i < binaryLen; i++) {
            number <<= 1;
            if (this.number[i]) {
                number++;
            }
        }
        return number;
    }
}
