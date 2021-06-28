package lc;

/**
 * 有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
 *
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 *
 * 提示:
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 *
 * 思路: 转换为目标表达式求值,给定数组前面添加正负号,找到最小的大于等于0的解
 * @author hawdies
 * @date 2021/6/8
 **/
public class N1049LastStoneWeight02 {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n + 1][6001];
        dp[0][3000] = true;
        for (int i = 1; i <= n; i++) {
            int tmp = stones[i - 1];
            for (int j = 0; j < 6001; j++) {
                if (j - tmp >= 0) {
                    dp[i][j] |= dp[i - 1][j - tmp];
                }
                if (j + tmp <= 6000) {
                    dp[i][j] |= dp[i - 1][j + tmp];
                }
            }
        }
        for (int i = 3000; i < 6001; i++) {
            if (dp[n][i]) return i - 3000;
        }
        return 0;

    }
}
