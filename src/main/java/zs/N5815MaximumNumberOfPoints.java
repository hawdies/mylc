package zs;

/**
 * description: 给你一个 m x n 的整数矩阵 points （下标从 0 开始）。一开始你的得分为 0 ，你想最大化从矩阵中得到的分数。
 * 你的得分方式为：每一行 中选取一个格子，选中坐标为 (r, c) 的格子会给你的总得分 增加 points[r][c] 。
 * 然而，相邻行之间被选中的格子如果隔得太远，你会失去一些得分。对于相邻行 r 和 r + 1 （其中 0 <= r < m - 1），选中坐标为 (r, c1) 和 (r + 1, c2) 的格子，你的总得分 减少 abs(c1 - c2) 。
 * 请你返回你能得到的 最大得分。
 *
 * @author hawdies
 * @date 2021/7/18
 **/
public class N5815MaximumNumberOfPoints {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[2][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            int row = i % 2;
            int pre = (i + 1) % 2;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[row][j] = Math.max(dp[row][j], dp[pre][k] + points[i][j] - Math.abs(k - j));
                }
            }
        }
        long res = 0;
        int row = (m - 1) % 2;
        for (int j = 0; j < n; j++) {
            res = Math.max(dp[row][j], res);
        }
        return res;
    }
}
