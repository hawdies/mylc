package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * 双向链表 + Map实现LRU
 *
 * @author hawdies
 * @Date 2021/3/24
 **/
public class N146LRUCache {
    static class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public CacheNode() {
        }
    }

    private int capacity;
    private CacheNode head;
    private CacheNode tail;
    private Map<Integer, CacheNode> cache;

    // 使用head, tail两个哨兵节点避免判空
    public N146LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        // 存在则移动到队头
        if (cache.get(key) != null) {
            move2Head(key);
            return cache.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        // 存在则覆盖原value
        // 并移动到对头
        // 调用get方法时已经移动过
        if (get(key) != -1) {
            cache.get(key).value = value;
        }
        // 不存在则添加新节点到队头,添加前如果容量已满,则删除尾节点
        else {
            if (cache.size() == capacity) removeLast();
            CacheNode node = new CacheNode(key, value);
            cache.put(key, node);
            addNewNode2Head(node);
        }
    }

    private void move2Head(int key) {
        CacheNode node = cache.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }

    private void removeLast() {
        CacheNode node = tail.prev;
        cache.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }

    private void addNewNode2Head(CacheNode cacheNode) {
        cacheNode.next = head.next;
        cacheNode.prev = head;
        head.next.prev = cacheNode;
        head.next = cacheNode;
    }

}
