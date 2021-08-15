package lc;

/**
 * description:
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。
 * 你最多可以移动 maxMove次球。
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 * <p>
 * 思路: 动态规划, dp[i][j][k]表示移动i次到达(j, k)的路径数.
 *
 * @author hawdies
 * @date 2021/8/15
 **/
public class N576OutOfBoundaryPaths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int res = 0;
        int[][][] dp = new int[maxMove + 1][m][n];
        final int MOD = (int)(1e9 + 7);
        dp[0][startRow][startColumn] = 1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[i][j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0];
                            int k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dp[i + 1][j1][k1] = (count + dp[i + 1][j1][k1]) % MOD;
                            } else {
                                res = (res + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
