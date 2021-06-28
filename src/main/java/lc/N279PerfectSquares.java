package lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hawdies
 * @Date 2021/4/6
 **/
public class N279PerfectSquares {
    private Set<Integer> squareNums = new HashSet<>();

    public int numSquares(int n) {
        for (int i = 1; i * i <= n; i++) {
            squareNums.add(i * i);
        }
        for (int i = 1; i <= n; i++) {
            if (isCount(n, i)) return i;
        }
        return n;
    }
    // 解法2:使用递归求解
    private boolean isCount(int n, int count) {
        if (count == 1) return squareNums.contains(n);
        for (Integer e : squareNums) {
            if (isCount(n - e, count - 1)) return true;
        }
        return false;
    }

    // 方法1:使用动态规划求解
    private int fun1(int n) {
        int[] dp = new int[n + 1];
        int squaresMaxLen = (int) (Math.sqrt(n) + 1);
        int[] squares = new int[squaresMaxLen];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            squares[i] = i * i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < squaresMaxLen; j++) {
                if (i < squares[j]) break;
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }
        return dp[n];
    }
}
