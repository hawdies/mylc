package wangyi.solution02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/4/18
 **/
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 计算探险游戏的最高得分
     *
     * @param m      int整型 层数
     * @param points int整型二维数组 每层据点分值
     * @param clues  Interval类二维数组 每层据点线索，第k行的[i, j]表示k层i据点可通往k+1层j据点
     * @return int整型
     */
    public int solve(int m, int[][] points, Interval[][] clues) {
        // write code here
        List<List<Interval>> lists = new ArrayList<>();
        int n = clues[0].length;
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < clues.length; i++) {
            for (int j = 0; j < clues[i].length; j++) {
                if (i == 0) lists.get(j).add(clues[i][j]);
                else {
                    for (int k = 0; k < n; k++) {
                        List<Interval> list = lists.get(k);
                        if (list.get(list.size() - 1).end == clues[i][j].start) {
                            list.add(clues[i][j]);
                        }
                    }
                }
            }
        }
        lists.removeIf(next -> next.size() < m - 1);
        long res = Long.MIN_VALUE;
        for (int i = 0; i < lists.size(); i++) {
            int curr = 0;
            List<Interval> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                curr += points[j][list.get(j).start];
            }
            curr += points[list.size() - 1][list.get(list.size() - 1).end];
            res = Math.max(res, curr);
        }

        return (int) res;
    }
}


class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

