package lc;

import java.util.*;

/**
 * description: 存在一个由 n 个不同元素组成的整数数组 nums ，但你已经记不清具体内容。好在你还记得 nums 中的每一对相邻元素。
 * 给你一个二维整数数组 adjacentPairs ，大小为 n - 1 ，其中每个 adjacentPairs[i] = [ui, vi] 表示元素 ui 和 vi 在 nums 中相邻。
 * 题目数据保证所有由元素 nums[i] 和 nums[i+1] 组成的相邻元素对都存在于 adjacentPairs 中，存在形式可能是 [nums[i], nums[i+1]] ，
 * 也可能是 [nums[i+1], nums[i]] 。这些相邻元素对可以 按任意顺序 出现。
 * 返回 原始数组 nums 。如果存在多种解答，返回 其中任意一个即可
 *
 * 思路: 使用一个set找出只出现一次的元素,使用一个map找出每个元素的相邻的元素.注意对于每对pair都要pair[0], pair[1]都要作为key加入到map中.
 *
 * @author hawdies
 * @date 2021/7/25
 **/
public class N1743ResoreArrayFormAdjacentPairs {
    public static void main(String[] args) {
        int[][] adjacentPairs = {
                {2, 1},
                {3, 4},
                {3, 2}
        };
        N1743ResoreArrayFormAdjacentPairs demo = new N1743ResoreArrayFormAdjacentPairs();
        int[] ints = demo.restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(ints));
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs == null || adjacentPairs.length == 0) return new int[0];
        int n = adjacentPairs.length;
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            int num1 = adjacentPair[0];
            int num2 = adjacentPair[1];
            List<Integer> value1 = map.getOrDefault(num1, new ArrayList<>());
            value1.add(num2);
            map.put(num1, value1);
            List<Integer> value2 = map.getOrDefault(num2, new ArrayList<>());
            value2.add(num1);
            map.put(num2, value2);
            if (set.contains(num1)) {
                set.remove(num1);
            } else {
                set.add(num1);
            }
            if (set.contains(num2)) {
                set.remove(num2);
            } else {
                set.add(num2);
            }
        }
        List<Integer> res = new ArrayList<>();
        int pre = set.iterator().next();
        res.add(pre);
        set.clear();
        set.add(pre);
        int count = 1;
        while (count <= n) {
            List<Integer> list = map.get(pre);
            Integer a = list.get(0);
            Integer b = list.size() > 1 ? list.get(1) : null;
            if (!set.contains(a)) {
                res.add(a);
                set.add(a);
                pre = a;
            } else {
                res.add(b);
                set.add(b);
                pre = b;
            }
            count++;
        }
        return res.stream().mapToInt(a -> a).toArray();
    }
}
