package lc;

import java.util.Arrays;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 * <p>
 * 思路: 使用二维数组array, array[i][0]表示引用数, array[i][1]表示大于此引用数的论文数量;
 * Math.min(array[i][0], array[i][1])表示当前i的h指数;
 * 然后遍历i取最大,就是最终结果.
 *
 * @author hawdies
 * @date 2021/7/11
 **/
public class N274HIndex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = citations[i];
            dp[i][1] = n - i;
        }
        int res = 0;
        for (int[] ints : dp) {
            int min = Math.min(ints[0], ints[1]);
            res = Math.max(res, min);
        }
        return res;
    }
}
