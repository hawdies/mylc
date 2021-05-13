/**
 * description: 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 *
 * 思路: 使用动态规划求解, dp[i][j]表示当前位置在j,剩余i步未用,所表示能到达index=0的所有方案. 最终返回dp[0][0]
 * 可知:
 * 初始条件为dp[steps][0]=1;
 * 转移方程为: dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1] + dp[i + 1][j - 1];
 * 注意i,j不要数组越界
 *
 * @author hawdies
 * @date 2021/5/13
 **/
public class N1269NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    public int numWays(int steps, int arrLen) {
        final int MOD = (int) 1e9 + 7;
        int maxLen = Math.min(steps / 2, arrLen - 1);
        int[][] dp = new int[2][maxLen + 1];
        dp[steps & 1][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            int edge = Math.min(i, maxLen);
            int a = i & 1;
            int b = (i + 1) & 1;
            for (int j = 0; j <= edge; j++) {
                dp[a][j] = (dp[a][j] + dp[b][j]) % MOD;
                if (j - 1 >= 0) {
                    dp[a][j] = (dp[a][j] + dp[b][j - 1]) % MOD;
                }
                if (j + 1 <= maxLen) {
                    dp[a][j] = (dp[a][j] + dp[b][j + 1]) % MOD;
                }
            }
        }
        return dp[0][0];
    }
}
