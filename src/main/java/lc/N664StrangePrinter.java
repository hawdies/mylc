package lc;

/**
 * description: 有台奇怪的打印机有以下两个特殊要求：
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 * 思路: 使用动态规划求解, 划分左右端点,以及区间长度,找到转移方程
 *
 * @author hawdies
 * @date 2021/5/24
 **/
public class N664StrangePrinter {
    public int strangePrinter(String s) {
        int n = s.length();
        // 第n + 1行 为边界条件
        // 边界条件对角线左侧均为0(因为此时左端点大于右端点)
        int[][] dp = new int[n + 1][n];
        // 枚举区间长度
        for (int len = 1; len <= n; len++) {
            // 枚举左端点
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r] = dp[l + 1][r] + 1;
                // 遍历区间的每个分割点
                for (int k = l + 1; k  <= r; k++) {
                    if (s.charAt(l) == s.charAt(k)) {
                        dp[l][r] = Math.min(dp[l][r], dp[l][k-1] + dp[k + 1][r]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
