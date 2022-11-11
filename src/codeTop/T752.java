package codeTop;

import java.util.*;

public class T752 {
    // 记录不能访问的结点
    private Set<String> forbidden;

    public int openLock(String[] deadends, String target) {
        // 边界条件判定
        if (target.equals("0000")) {
            return 0;
        }
        // 用来分别记录从前搜索和从后搜索的已经访问过的结点
        Map<String, Integer> visitedForward = new HashMap<>();
        Map<String, Integer> visitedBackward = new HashMap<>();
        forbidden = new HashSet<>();
        forbidden.addAll(Arrays.asList(deadends));
        if (forbidden.contains(target) || forbidden.contains("0000")) {
            return -1;
        }
        // 用来做bfs找最短距离的两个queue，分别代表前向搜索和反向搜索
        Queue<String> queueForward = new LinkedList<>();
        Queue<String> queueBackward = new LinkedList<>();
        queueForward.add("0000");
        visitedForward.put("0000", 0);
        queueBackward.add(target);
        visitedBackward.put(target, 0);

        // 当两个组都非空时，对队列中的每一个元素分别搜索
        while (!queueForward.isEmpty() && !queueBackward.isEmpty()) {
            int ans;
            if (queueForward.size() <= queueBackward.size()) {
                ans = search(queueForward, visitedForward, visitedBackward);
            } else {
                ans = search(queueBackward, visitedBackward, visitedForward);
            }
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    // 搜索queue中的内容的下一次可能值，将其加入到queue中。返回-1代表没有搜索到，搜索到了则返回其具体值
    private int search(Queue<String> queue, Map<String, Integer> current, Map<String, Integer> other) {
        // 只搜当前的一层，所以只搜queue中进入函数有的部分，其余部分不进行搜索
        int searchEpoch = queue.size();
        for (int i = 0; i < searchEpoch; i++) {
            String string = queue.poll();
            // 获得string的所有下一步可能的状态
            List<String> nextStrings = nextStepList(string);
            for (String nextString : nextStrings) {
                // 如果这个字符已经被搜索过或者是deadEnd，则不继续搜索
                if (current.containsKey(nextString) || forbidden.contains(nextString)) {
                    continue;
                }
                // 如果在另一个方向已经搜到该字符，证明这条路径就是最短路径，返回该路径
                if (other.containsKey(nextString)) {
                    return current.get(string) + 1 + other.get(nextString);
                }
                // 如果都不在，则将其加入到bfs的队列中，等待下次的搜索
                queue.add(nextString);
                current.put(nextString, current.get(string) + 1);
            }
        }
        return -1;
    }

    private List<String> nextStepList(String string) {
        List<String> ans = new ArrayList<>();
        for (int index = 0; index < 4; index++) {
            ans.add(turn(string, index, true));
            ans.add(turn(string, index, false));
        }
        return ans;
    }

    private String turn(String string, int index, boolean up) {
        StringBuilder str = new StringBuilder(string);
        char c = str.charAt(index);
        if (up) {
            if (c == '9') {
                c = '0';
            } else {
                c = (char)((int)c + 1);
            }
        } else {
            if (c == '0') {
                c = '9';
            } else {
                c = (char)((int)c - 1);
            }
        }
        str.setCharAt(index, c);
        return str.toString();
    }
}
