package lc;

import java.util.*;
import java.util.function.ToIntFunction;

/**
 * description: 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * @author hawdies
 * @date 2021/5/20
 **/
public class N692TopKFrequentWords {

    // 使用hashmap + 排序的方式求解
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());

        list.sort(Comparator.comparingInt((ToIntFunction<String>) map::get).thenComparing(Comparator.reverseOrder()));
//        list.sort((s1, s2) -> {
//            int cmp = map.get(s1) - map.get(s2);
//            if (cmp == 0) {
//                cmp = s2.compareTo(s1);
//            }
//            return cmp;
//        });
        Collections.reverse(list);
        return list.subList(0, k);
    }

    // 使用优先队列求解
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((s1, s2) -> {
            int cmp = map.get(s1) - map.get(s2);
            if (cmp == 0) {
                cmp = s2.compareTo(s1);
            }
            return cmp;
        });
        for (String str : map.keySet()) {
            priorityQueue.add(str);
            if (priorityQueue.size() > k) {
                priorityQueue.remove();
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.remove());
        }
        Collections.reverse(list);
        return list;
    }
}
