package lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description: 存在一个由 n 个节点组成的无向连通图，图中的节点按从 0 到 n - 1 编号。
 * 给你一个数组 graph 表示这个图。其中，graph[i] 是一个列表，由所有与节点 i 直接相连的节点组成。
 * 返回能够访问所有节点的最短路径的长度。你可以在任一节点开始和停止，也可以多次重访节点，并且可以重用边。
 * n == graph.length
 * 1 <= n <= 12
 * 0 <= graph[i].length < n
 * graph[i] 不包含 i
 * 如果 graph[a] 包含 b ，那么 graph[b] 也包含 a
 * 输入的图总是连通图
 *
 * 思路: 状态压缩 + BFS
 * @author hawdies
 * @date 2021/8/6
 **/
public class N847ShortestPathVisitingAllNodes {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][1<<n];
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {i, 1 << i, 0});
            visited[i][1 << i] = true;
        }
        int res = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int v = poll[0];
            int mask = poll[1];
            int dist = poll[2];
            if (mask == (1 << n) - 1) {
                res = dist;
                break;
            }
            for (int w : graph[v]) {
                int maskW = mask | 1 << w;
                if (!visited[w][maskW]) {
                    queue.offer(new int[]{w, maskW, dist + 1});
                    visited[w][maskW] = true;
                }
            }
        }
        return res;
    }
}
