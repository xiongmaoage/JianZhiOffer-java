package codeTop;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class T210 {
    private int[][] prerequisites;
    // 入度统计情况
    private int[] inDegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        this.prerequisites = prerequisites;
        inDegree = new int[numCourses];
        // 获得入度统计结果
        calInDegree();
        // 找到入度为0的结点，并放入队列
        Queue<Integer> queue = findCourseWithoutPre();
        // 对于队列的每一个课程，将其加到order中，并在图中删除该节点，同步更新度矩阵，将新的度为0的点加入queue
        int[] order = new int[numCourses];
        int orderIndex = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[orderIndex++] = course;
            // 删除该节点，并更新度矩阵
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == course) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        // 如果有环，则当前order的长度没有满，返回空数组，否则返回order
        if (orderIndex < numCourses) {
            return new int[0];
        } else {
            return order;
        }
    }

    private void calInDegree() {
        Arrays.fill(inDegree, 0);
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }
    }

    // 找到入度为0的点，放入队列中，并将其入度置为-1
    private Queue<Integer> findCourseWithoutPre() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        return queue;
    }
}
