package codeTop;

import java.util.ArrayList;
import java.util.List;

public class T386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        int number = 1;
        // 因为需要输出n个数，所以只需要执行n次，可以设为停止条件
        for (int i = 0; i < n; i++) {
            ans.add(number);
            if (number * 10 <= n) {
                number *= 10;
            } else {
                // 如果走到了分支的最后一个节点，或者超过了上界，则手动回溯，需要持续回溯，所以是while
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return ans;
    }
}
