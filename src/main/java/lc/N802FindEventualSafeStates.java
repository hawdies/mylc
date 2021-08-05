package lc;

import java.util.*;

/**
 * description:在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。
 * 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。
 * 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。
 * 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是graph的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，满足 (i, j) 是图的一条有向边。
 *
 * 思路1: 深度优先遍历, 所有在环上的点均不是安全点
 *
 * 思路2: 广度优先遍历, 拓扑排序后未遍历的点均不是安全点.
 * 注意: 题目中"没有出边的点是终点(即安全点)",
 * 这与拓扑排序的条件正好相反,没有入度的点可以作为拓扑排序起点,因此需要将图中的边反转后,按照拓扑排序求解.
 * @author hawdies
 * @date 2021/8/5
 **/
public class N802FindEventualSafeStates {

    // 深度优先遍历
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe(graph, visited, i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean safe(int[][] graph, int[] visited, int i) {
        if (visited[i] > 0) return visited[i] == 2;
        visited[i] = 1;
        for (int w : graph[i]) {
            if (!safe(graph, visited, w)) {
                return false;
            }
        }
        visited[i] = 2;
        return true;
    }


    // 广度优先遍历
    public List<Integer> eventualSafeNodes02(int[][] graph) {
        // 将图反置(即找到反图), 然后根据入度进行拓扑排序
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int e : graph[i]) {
                indegree[i]++;
                adj.get(e).add(i);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
                res.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : adj.get(v)) {
                if (!visited[w] && --indegree[w] == 0) {
                    queue.offer(w);
                    visited[w] = true;
                    res.add(w);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
