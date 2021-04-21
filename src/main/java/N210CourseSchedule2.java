import java.util.*;

/**
 * description: 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * 本质为求解图的拓扑排序问题:分为深度优先和广度优先两种.
 * <p>
 * 方法一: 深度优先求拓扑排序
 * 根据题意确定邻接矩阵
 * 然后以每个入度为0的点作为起点,进行深度优先遍历.
 * 深度优先遍历过程中,需要判断是否存在环,存在环则直接返回空数组.
 * 对于最后遍历的list链表需要反转(因为最后一个点先放入链表中)
 * 如果list的size小于numCourses,说明存在无返回的点,此时也应该返回空数组.
 * <p>
 * 方法二: 广度优先求拓扑排序
 *
 * @author hawdies
 * @date 2021/4/20
 **/
public class N210CourseSchedule2 {
    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return methodBFS(numCourses, prerequisites);
    }

    // 方法一: dfs求拓扑排序
    public int[] methodDFS(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<List<Integer>> adjust = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjust.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            adjust.get(info[1]).add(info[0]);
        }
        // 访问标记 0:表示为访问, 1:表示正在访问 2:表示访问完成
        int[] visited = new int[numCourses];
        // 结果
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0)
                dfs(i, stack, visited, adjust);
            if (hasCycle) return new int[0];
        }
        // LinkedList采用链表,栈顶在队头,故不需要反转.如果使用Stack(内部使用数组),则需要反转;
        // Collections.reverse(stack);
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int point, LinkedList<Integer> stack, int[] visited, List<List<Integer>> adjust) {
        visited[point] = 1;
        for (Integer v : adjust.get(point)) {
            if (visited[v] == 0) dfs(v, stack, visited, adjust);
            else if(visited[v] == 1) {
                hasCycle = true;
                return;
            }
        }
        visited[point] = 2;
        stack.push(point);
    }

    // 方法二: bfs求拓扑排序a
    public int[] methodBFS(int numCourses, int[][] prerequisites) {
        //入度信息
        int[] table = new int[numCourses];
        Set<Integer> set = new HashSet<>();
        // 构建邻接表
        List<List<Integer>> adjust = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjust.add(new ArrayList<>());
        }
        for (int[] info : prerequisites) {
            adjust.get(info[1]).add(info[0]);
            table[info[0]]++;
        }
        // 结果
        List<Integer> res = new ArrayList<>();
        // 入度为0的队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (table[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (Integer neighbor : adjust.get(node)) {
                if (--table[neighbor] == 0) queue.offer(neighbor);
            }
        }
        if (res.size() < numCourses) return new int[0];
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
