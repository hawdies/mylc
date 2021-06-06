/**
 * @author hawdies
 * @date 2021/6/6
 **/
public class N474OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        // 0-1背包
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        // 统计每个字符串中'0', '1'的个数
        int[][] cnt = new int[len][2];

        for (int i  = 0; i < strs.length; i++) {
            for (int j = 0; j <strs[i].length(); j++) {
                if (strs[i].charAt(j) == '0') cnt[i][0]++;
                else cnt[i][1]++;
            }
        }

        for (int i = 1; i <= len; i++) {
            int cur0 = cnt[i - 1][0];
            int cur1 = cnt[i - 1][1];
            for (int j = 0; j <= m; j++){
                for (int k = 0; k <= n; k++) {
                    if (j - cur0 >= 0 && k - cur1 >= 0)
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cur0][k - cur1] + 1);
                    else dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }

        return dp[len][m][n];
    }
}
