package codeTop;

import java.util.LinkedList;
import java.util.Queue;

public class T207 {
    // 记录已经查询过的结点
    private int history;
    private int numCourses;
    private int[] inDegree;
    private int[][] prerequisites;

    // 本质上是在一个边的集合中找是否含有环（无自环）
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        history = 0;
        this.numCourses = numCourses;
        this.prerequisites = prerequisites;
        // 用来存储每个结点的入度
        getCoursesInDegree(prerequisites);
        boolean hasNewCourse = true;
        while (hasNewCourse) {
            hasNewCourse = add0Degree2Queue();
        }
        return history == numCourses;
    }

    // 计算每个结点的入度
    private void getCoursesInDegree(int[][] prerequisites) {
        inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
        }
    }

    private boolean add0Degree2Queue() {
        boolean hasNewCourse = false;
        for (int course = 0; course < numCourses; course++) {
            if (inDegree[course] == 0) {
                hasNewCourse = true;
                inDegree[course] = -1;  // 将其状态置为已访问
                history++;
                for (int[] prerequisite : prerequisites) {
                    if (prerequisite[0] == course) {
                        inDegree[prerequisite[1]]--;
                    }
                }
            }
        }
        return hasNewCourse;
    }
}
