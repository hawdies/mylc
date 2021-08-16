package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/8/16
 **/
public class N526BeautifulArrangement {

    public static void main(String[] args) {
        N526BeautifulArrangement demo = new N526BeautifulArrangement();
        int i = demo.countArrangement02(2);
        System.out.println(i);
    }

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
