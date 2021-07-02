package lc;

import java.util.Arrays;

/**
 * description: 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * 注意：Tony 可以按任意顺序购买雪糕。
 *
 * 思路: 先对costs[]进行排序, 使用贪心算法求解.
 * @author hawdies
 * @date 2021/7/2
 **/
public class N1833MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if (coins < costs[0]) return 0;
        int res = 0;
        for (int cost : costs) {
            coins -= cost;
            if (coins < 0) break;
            res++;
        }
        return res;
    }
}
