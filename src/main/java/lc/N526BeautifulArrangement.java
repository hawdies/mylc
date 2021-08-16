package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * 假设有从 1 到 N 的N个整数，如果从这N个数字中成功构造出一个数组，使得数组的第 i位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：
 * 第i位的数字能被i整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 * N 是一个正整数，并且不会超过15。
 * <p>
 * 思路1: 回溯
 * 思路2: 状态压缩 + 动态规划
 *
 * @author hawdies
 * @date 2021/8/16
 **/
public class N526BeautifulArrangement {
    // 状态压缩 +  动态规划
    public int countArrangement02(int n) {
        int[] dp = new int[1 << n];
        dp[0] = 1;
        for (int mask = 1; mask < 1 << n; mask++) {
            int num = Integer.bitCount(mask);
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0 && (num % (j + 1) == 0 || (j + 1) % num == 0)) {
                    dp[mask] += dp[mask ^ 1 << j];
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    List<Integer>[] matched;
    boolean[] visited;
    int num = 0;

    // 回溯
    public int countArrangement(int n) {
        visited = new boolean[n + 1];
        matched = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            matched[i] = new ArrayList<>();
            for (int j = 1; j <= n; j++) {
                if (j % i == 0 || i % j == 0) {
                    matched[i].add(j);
                }
            }
        }
        backtrack(1, n);
        return num;
    }

    private void backtrack(int index, int n) {
        if (index == n + 1) {
            num++;
            return;
        }
        for (Integer e : matched[index]) {
            if (!visited[e]) {
                visited[e] = true;
                backtrack(index + 1, n);
                visited[e] = false;
            }
        }
    }
}
