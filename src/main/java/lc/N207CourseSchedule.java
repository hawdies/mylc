package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 图遍历相关操作
 * 判断是否有环
 *
 * @author hawdies
 * @Date 2021/3/25
 **/
public class N207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return inDegrees(numCourses, prerequisites);
    }

    // 通过拓扑排序判断是否有环
    private boolean inDegrees(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] temp : prerequisites) {
            // 入度
            indegrees[temp[0]]++;
            // 出度表
            adjacency.get(temp[1]).add(temp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            numCourses--;
            for (int temp : adjacency.get(course)) {
                if (--indegrees[temp] == 0) queue.add(temp);
            }
        }
        return numCourses == 0;
    }


    private boolean cycle = false;
    private boolean[] onStack;
    private boolean[] visited;

    private boolean directedCycle(int numCourses, int[][] prerequisites) {
        onStack = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] temp : prerequisites) {
            // 邻接表
            adjacency.get(temp[1]).add(temp[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                dfs(i, adjacency);
            }
        }
        return !cycle;
    }

    // 通过深度优先遍历判断是否有环
    private void dfs(int v, List<List<Integer>> adjacency) {
        visited[v] = true;
        onStack[v] = true;

        for (Integer w : adjacency.get(v)) {
            if (cycle) return;
            if (!visited[w]) {
                dfs(w, adjacency);
            } else if (onStack[w]) {
                cycle = true;
            }
        }
        onStack[v] = false;
    }

}
