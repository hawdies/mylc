package lc;

import java.util.*;

/**
 * description: 给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。
 * 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... 这样的车站路线行驶。
 * 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。
 * 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。
 *
 * 思路: 将公交车看作点,如果两个公交车路线中有站点重复,那么这个两个公交车有边,长度为1. 使用BFS遍历指定目标和终点的最短路径
 * 根据上述描述构建图.
 * 建图详解: 使用map,k -> 站点station, v -> 该站点经过的公交车(使用List).使用该map可以构建邻接矩阵{@code boolean[][] adjust}.
 * 由于题意是出发站点唯一,终点站点唯一;但一个站点可能有多个公交经过,因此需要计算每个可以作为出发点的公交车,以及每个作为终点的公交车.
 * 具体: 使用队列将可以作为起点的公交入队,用一个数组dis[i]表示从出发点公交s到当前公交i的最短距离(即最少换乘次数).
 * 由于出发点可能有多个公交,如果保证最短距离?
 * {@code adjust[bus][i] && dis[i] == -1} 通过dis[i] == -1来判断i节点是否已经被访问过了,如果访问过则肯定是最短距离,不必更新.
 * 如何保证终点站台有多个公交车情况下取得最短距离?
 * 通过之前的map.get(target)可以找到能到达终点所有的公交车,对每个公交车根据之前dis[i]来找到对应的距离,然后取最小.
 *
 * @author hawdies
 * @date 2021/6/28
 **/
public class N815BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        // 邻接矩阵
        boolean[][] adjust = new boolean[n][n];
        // k -> station, v -> buses
        // 为构建邻接矩阵
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int station : routes[i]) {
                List<Integer> list = map.getOrDefault(station, new ArrayList<>());
                for (int j : list) {
                    adjust[i][j] = adjust[j][i] = true;
                }
                list.add(i);
                map.put(station, list);
            }
        }

        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        for (int bus : map.getOrDefault(source, new ArrayList<>())) {
            queue.add(bus);
            dis[bus] = 1;
        }

        while (!queue.isEmpty()) {
            int bus = queue.poll();
            for (int j = 0; j < n; j++) {
                // 如果dis[j] != -1,说明之前已经访问到j点,距离一定小于等于此时的值,故不更新
                if (adjust[bus][j] && dis[j] == -1) {
                    dis[j] = dis[bus] + 1;
                    queue.add(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int bus : map.getOrDefault(target, new ArrayList<>())) {
            if (dis[bus] != -1)
                res = Math.min(res, dis[bus]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
