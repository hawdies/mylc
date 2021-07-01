package lc;

import java.util.*;

/**
 * description: 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 *
 * 思路: 使用图的层序遍历
 * @author hawdies
 * @date 2021/7/1
 **/
public class NLCP07ChuanDiXinxi {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] items : relation) {
            int key = items[0];
            int value = items[1];
            Set<Integer> set = map.getOrDefault(key, new HashSet<>());
            set.add(value);
            map.put(key, set);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int trans = -1;
        int count = 0;
        while (!queue.isEmpty()) {
            trans++;
            if (trans > k) break;
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int key = queue.poll();
                if (key == n - 1 && k == trans) count++;
                Set<Integer> set = map.get(key);
                if (set == null) continue;
                queue.addAll(set);
            }
        }
        return count;
    }
}
