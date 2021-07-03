package lc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description: 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 思路: map统计词频, 根据k,v构造节点.使用PriorityQueue优先队列根据节点自定义排序规则.将queue出队完成构建.
 *
 * @author hawdies
 * @date 2021/7/3
 **/
public class N451SortCharactersByFrequency {

    class Node {
        private char c;
        private int v;

        public Node(char c, int v) {
            this.c = c;
            this.v = v;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Queue<Node> queue = new PriorityQueue<>((a, b) -> {
            if (a.v == b.v) {
                return a.c - b.c;
            } else {
                return b.v - a.v;
            }
        });
        map.forEach((key, value) -> queue.offer(new Node(key, value)));
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int v = node.v;
            while (v-- > 0) sb.append(node.c);
        }
        return sb.toString();
    }
}
