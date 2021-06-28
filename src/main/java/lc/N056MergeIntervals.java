package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组区间合并
 * <p>
 * 二维数组的遍历
 * list与array的相互转换
 *
 * @author hawdies
 * @Date 2021/3/1
 **/
public class N056MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {1, 2}};
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.stream(intervals).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        if (intervals.length > 0) list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = list.get(list.size() - 1);
            if (current[1] < intervals[i][0]) {
                list.add(intervals[i]);
            } else {
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][0]);
    }
}
