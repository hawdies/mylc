/**
 * 动态规划求解最大矩形面积
 *
 * @author hawdies
 * @Date 2021/3/29
 **/
public class N221MaximumSquare {
    public static void main(String[] args) {
        char[][] martix = {
                {'0', '0', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '1', '1'},
                {'0', '1', '1', '1'},
                {'0', '1', '1', '1'}
        };
        maximalSquare(martix);
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n]; // dp表示以i, j为右小角点的最大的正方形的边长;
        int maxSide = 0;
        // 初始化边界
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j] - '0';
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                    // 此段逻辑实际上可以简化为 dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1
//                else {
//                    int count = dp[i - 1][j - 1];
//                    boolean flag = true;
//                    for (int x = 1; x <= count; x++) {
//                        if (matrix[i][j - x] == '0') {
//                            // 核心逻辑
//                            dp[i][j] = x;
//                            flag = false;
//                            break;
//                        }
//                        if (matrix[i - x][j] == '0') {
//                            dp[i][j] = x;
//                            flag = false;
//                            break;
//                        }
//                    }
//                    if (flag) dp[i][j] = dp[i - 1][j - 1] + 1;
//                }
//                maxSide = Math.max(maxSide, dp[i][j]);
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
                maxSide = Math.max(maxSide, dp[i][j]);
            }
        }
        return maxSide * maxSide;
    }
}
