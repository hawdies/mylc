package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/6/11
 **/
public class N279PerfectSquares02 {
    // 朴素的完全背包问题
    // dp[i][j] 表示前i个数字组成j所需要的最少的个数
    public int numSquares(int n) {
        List<Integer> list = getCandidateNums(n);
        int m = list.size();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int curNum = list.get(i - 1);
            for (int j = 0; j <= n; j++) {
                int k = 1;
                dp[i][j] = dp[i - 1][j];
                while (j - k * curNum >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * curNum] + k);
                    k++;
                }
            }
        }
        return dp[m][n];
    }

    // 优化为一维的背包dp[i]表示组成i需要的最少的完全平方数的个数
    public int numSquares2(int n) {
        List<Integer> list = getCandidateNums(n);
        int m = list.size();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int curNum : list) {
            for (int j = curNum; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - curNum] + 1);
            }
        }
        return dp[n];
    }

    private List<Integer> getCandidateNums(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            list.add(i * i);
        }
        return list;
    }
}
