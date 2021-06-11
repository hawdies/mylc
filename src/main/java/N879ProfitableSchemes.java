/**
 * 
 * description: 集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
 * 第i种工作会产生profit[i]的利润，它要求group[i]名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。
 * 工作的任何至少产生minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。
 * 有多少种计划可以选择？因为答案很大，所以 返回结果模10^9 + 7的值。
 *
 * 思路,使用背包求解.
 * dp[i][j][k]: 表示前k个任务中选择了j个员工,获得的利润不少于k.(重点是k表示利润不少于k,而非仅仅等于k)
 * @author hawdies
 * @date 2021/6/9
 **/
public class N879ProfitableSchemes {
    public static void main(String[] args) {
        int n = 5;
        int minProfit = 3;
        int[] group = {2, 2};
        int[] profit = {2, 3};
        int res = new N879ProfitableSchemes().profitableSchemes(n, minProfit, group, profit);
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        final int MOD = (int)(1e9 + 7);
        dp[0][0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int people = group[i - 1];
            int curProfit = profit[i - 1];
            for  (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (people <= j) {
                        // 此句表示在员工人数足够情况下:
                        // 如果k - currProfit < 0, 说明除了当前这项任务,前面的任何一个任务都没有选择.(只有这种情况才会<0的情况)
                        int index3 = Math.max(0, k - curProfit);
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - people][index3]) % MOD;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[len][i][minProfit]) % MOD;
        }
        return sum;
    }
}
