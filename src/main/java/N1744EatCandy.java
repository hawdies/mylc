/**
 * description: 给你一个下标从 0 开始的正整数数组candiesCount，其中candiesCount[i]表示你拥有的第i类糖果的数目。同时给你一个二维数组queries，其中queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]。
 *
 * 你按照如下规则进行一场游戏：
 *
 * 你从第0天开始吃糖果。
 * 你在吃完 所有第 i - 1类糖果之前，不能吃任何一颗第 i类糖果。
 * 在吃完所有糖果之前，你必须每天 至少吃 一颗糖果。
 * 请你构建一个布尔型数组answer，满足answer.length == queries.length 。answer[i]为true的条件是：在每天吃 不超过 dailyCapi颗糖果的前提下，你可以在第favoriteDayi天吃到第favoriteTypei类糖果；否则 answer[i]为 false。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 *
 * 请你返回得到的数组answer。
 *
 *
 * 思路: 以最快速度吃糖得到左边界left,以最慢速度吃糖得到右边界right.
 * 如果queries[i][2]在[left, right]区间内,那么就可以吃到,ans[i]=true,否则为false
 *
 * 使用前缀和来统计第i种类型及以前的糖果
 * 前缀和技巧: \
 * 1. 由于累加可能会超过int返回,故使用long[]数组存储
 * 2. 一般将sum[0]作为哨兵.表示没有元素时的默认值
 * @author hawdies
 * @date 2021/6/1
 **/
public class N1744EatCandy {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = candiesCount.length;
        int m = queries.length;
        long[] sum = new long[n + 1];
        boolean[] ans = new boolean[m];
        for (int i = 1; i < n + 1; i++) {
            // sum[i]表示元题意中的第i-1种糖果.题意中的糖果是从0开始,而sum求和时从1开始(0用来做哨兵).
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        for (int i = 0; i < m; i++) {
            // t表示糖果类型
            int t = queries[i][0];
            // d表示第几天, +1是因为我们计算中从第1天开始,而题意是从0开始.
            int d = queries[i][1] + 1;
            int c = queries[i][2];
            // left 表示以每天最大速率c吃糖, 吃到第t种类型糖果的最短的天数
            long left = sum[t] / c + 1;
            // 每天吃一颗糖果,吃到最后一颗第t种类型糖果的天数
            long right = sum[t + 1];
            if (d >= left && d <= right) {
                ans[i] = true;
            }
        }
        return ans;
    }
}
