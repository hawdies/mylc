/**
 *
 * description: 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
 *
 * 思路:
 * 方法1: 使用回溯+剪枝求解(会超时)
 * 方法2: 使用二维dp求解,dp[i][j]:表示在给定前i中硬币下,总金额为j的所有可能性.由于每种硬币可以选多种,故需要在二维for循环内部有一个while循环
 * 方法3: 使用一维dp求解(对方法2的有优化), dp[i]:表示总金额为i的所有可能性.需要针对针对不同给定的硬币种类进行求解,详见:{@link #change02}
 * @author hawdies
 * @date 2021/6/10
 **/
public class N518CoinChange2 {
    private int count;

    public int change(int amount, int[] coins) {
        // 回溯法
//        backtrack(amount, coins, 0, 0);
//        return count;

        // 动态规划求解组合问题
        // 未优化的二维dp
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                int k = 1;
                while (j >= k * coin) {
                    dp[i][j] += dp[i-1][j - k * coin];
                    k++;
                }
            }
        }
        return dp[n][amount];
    }

    // 优化为一维数组dp
    public int change02(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    // 回溯方法求解会超时
    private void backtrack(int amount, int[] coins, int index, int sum) {
        if (sum == amount) {
            count++;
            return;
        }
        if (index == coins.length || sum + coins[index] > amount) return;
        sum += coins[index];
        backtrack(amount, coins, index, sum);
        sum -= coins[index];
        backtrack(amount, coins, index + 1, sum);
    }
}
