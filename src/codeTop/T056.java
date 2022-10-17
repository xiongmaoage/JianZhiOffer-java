package codeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class T056 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }
        List<Integer[]> ans = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
        int floor = intervals[0][0];
        int ceil = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] <= ceil) {              // 需要合并
                ceil = Math.max(ceil, interval[1]);
            } else {                                // 另外创建新的内容
                ans.add(new Integer[]{floor, ceil});
                floor = interval[0];
                ceil = interval[1];
            }
        }
        ans.add(new Integer[]{floor, ceil});
        int[][] newIntervals = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            newIntervals[i] = new int[]{ans.get(i)[0], ans.get(i)[1]};
        }
        return newIntervals;
    }
}
