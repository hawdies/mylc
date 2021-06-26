import java.util.*;

/**
 * description: 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 思路: 双向广度优先搜索BFS,避免搜索空间爆炸, 参考{@link N752OpenTheLock}
 * tips,注意给定的是一个二维数组,使用hashmap时应将其转化为String
 * @author hawdies
 * @date 2021/6/26
 **/
public class N773SlidingPuzzle {
    private String start = "";
    private String end = "123450";
    public int slidingPuzzle(int[][] board) {
        for (int[] rows : board) {
            for (int e : rows) {
                start += e;
            }
        }
        if (start.equals(end)) return 0;
        int res = dfs();
        return res;
    }

    private int dfs() {
        int res = -1;
        Queue<String> queueFirst = new ArrayDeque<>();
        Queue<String> queueLast = new ArrayDeque<>();
        Map<String, Integer> mapFirst = new HashMap<>();
        Map<String, Integer> mapLast = new HashMap<>();

        queueFirst.add(start);
        mapFirst.put(start, 0);
        queueLast.add(end);
        mapLast.put(end, 0);
        while (!queueFirst.isEmpty() && !queueLast.isEmpty()) {
            if (queueFirst.size() <= queueLast.size()) {
                res = update(queueFirst, mapFirst, mapLast);
            } else {
                res = update(queueLast, mapLast, mapFirst);
            }
            if (res != -1) return res;
        }

        return -1;
    }

    private int update(Queue<String> queue, Map<String, Integer> map, Map<String, Integer> otherMap) {
        String curStr = queue.poll();
        int step = map.get(curStr);
        List<String> nextStrings = getNextStrings(curStr);
        for (String s : nextStrings) {
            if (map.containsKey(s)) continue;
            if (otherMap.containsKey(s)) {
                return step + 1 + otherMap.get(s);
            }
            queue.add(s);
            map.put(s, step + 1);
        }
        return -1;
    }

    private List<String> getNextStrings(String curStr) {
        List<String> list = new ArrayList<>();
        char[] chars = curStr.toCharArray();
        int index = curStr.indexOf('0');
        int row = index / 3;
        int col = index % 3;
        if (row - 1 >= 0) {
            int destIndex = (row - 1) * 3 + col;
            String s = getNewString(chars, index, destIndex);
            list.add(s);
        }
        if (row + 1 <=1) {
            int destIndex = (row + 1) * 3 + col;
            String s = getNewString(chars, index, destIndex);
            list.add(s);
        }
        if (col - 1 >= 0) {
            int destIndex = row * 3 + col - 1;
            String s = getNewString(chars, index, destIndex);
            list.add(s);
        }
        if (col + 1 <= 2) {
            int destIndex = row * 3 + col + 1;
            String s = getNewString(chars, index, destIndex);
            list.add(s);
        }
        return list;
    }

    private String getNewString(char[] chars, int index, int destIndex) {
        char c = chars[destIndex];
        char[] clone = chars.clone();
        clone[destIndex] = '0';
        clone[index] = c;
        return new String(clone);
    }
}
