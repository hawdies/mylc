package lc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author hawdies
 * @date 2021/7/10
 **/
public class N981TimeBaseKeyValueStore {
    static class Node {
        private String value;
        private int timestamp;

        public Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    private Map<String, PriorityQueue<Node>> map;
    /** Initialize your data structure here. */
    public N981TimeBaseKeyValueStore() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        PriorityQueue<Node> queue = map.getOrDefault(key, new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp));
        queue.offer(new Node(value, timestamp));
        map.put(key, queue);
    }

    public String get(String key, int timestamp) {
        PriorityQueue<Node> queue = map.getOrDefault(key, null);
        if (queue == null) return "";
        for (Node node : queue) {
            if (node.timestamp <= timestamp) return node.value;
        }
        return "";
    }
}
