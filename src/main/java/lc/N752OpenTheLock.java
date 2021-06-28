package lc;

import java.util.*;

/**
 * description: 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 * 思路:使用双向广度优先搜索BFS求解,避免空间爆炸问题
 * @author hawdies
 * @date 2021/6/25
 **/
public class N752OpenTheLock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (target.contains("0000")) return 0;
        if (set.contains("0000")) return -1;
        return dfs(set, target);
    }

    private int dfs(Set<String> set, String target) {
        int res = -1;
        Queue<String> queueFirst = new ArrayDeque<>();
        Queue<String> queueLast = new ArrayDeque<>();
        queueFirst.add("0000");
        queueLast.add(target);
        Set<String> visited = new HashSet<>();
        Map<String, Integer> mapFirst = new HashMap<>();
        Map<String, Integer> mapLast = new HashMap<>();
        mapFirst.put("0000", 0);
        mapLast.put(target, 0);
        while (!queueFirst.isEmpty() && !queueLast.isEmpty()) {
            if (queueFirst.size() <= queueLast.size()) {
                res = update(queueFirst, mapFirst, mapLast, set);
            } else {
                res = update(queueLast, mapLast, mapFirst, set);
            }
            if (res != -1) return res;
        }
        return res;
    }

    private int update(Queue<String> srcQueue, Map<String, Integer> srcMap, Map<String, Integer> otherMap, Set<String> set) {
        String curStr = srcQueue.poll();
        int step = srcMap.get(curStr);
        List<String> nextStrs = getNextStrs(curStr);
        for (String nextStr : nextStrs) {
            if (set.contains(nextStr)) continue;
            if (srcMap.containsKey(nextStr)) continue;
            if (otherMap.containsKey(nextStr)) {
                return step + 1 + otherMap.get(nextStr);
            } else {
                srcQueue.add(nextStr);
                srcMap.put(nextStr, step + 1);
            }
        }
        return -1;
    }

    private List<String> getNextStrs(String curStr) {
        List<String> list = new ArrayList<>();
        char[] chars = curStr.toCharArray();
        for (int i = 0; i < 4; i++) {
            char c = chars[i];
            char pre = getPreChar(c);
            char[] clonePre = chars.clone();
            clonePre[i] = pre;
            list.add(new String(clonePre));
            char next = getNextChar(c);
            char[] cloneNext = chars.clone();
            cloneNext[i] = next;
            list.add(new String(cloneNext));
        }
        return list;
    }

    private char getNextChar(char c) {
        return c == '9' ? '0' : (char) (c + 1);
    }

    private char getPreChar(char c) {
        return c == '0' ? '9' : (char) (c - 1);
    }
}
