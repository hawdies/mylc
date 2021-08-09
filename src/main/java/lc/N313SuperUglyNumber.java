package lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * description: 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * 提示：
 * 1 <= n <= 106
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * 题目数据 保证 primes[i] 是一个质数
 * primes 中的所有值都 互不相同 ，且按 递增顺序 排列
 *
 * 思路:
 * 方法1:小顶堆 + hash去重
 * 方法2: 动态规划
 * dp[i]: 表示第i大丑数. 对于primes数组,创建一个pointers数组,pointers[j]指向dp的下标,即dp[pointers[j]],表示perimes[j]质数生成的最近的丑数位置.
 * 确定好dp[i]的值后,需要根据dp[i]的值来移动pointers指向dp的位置.
 * @author hawdies
 * @date 2021/8/9
 **/
public class N313SuperUglyNumber {
    // 小顶堆 + hash去重
    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.offer(1L);
        for (int i = 1; i < n; i++) {
            Long poll = queue.poll();
            for (int prime : primes) {
                long value = poll * prime;
                if (set.add(value)) {
                    queue.add(value);
                }
            }
        }
        return queue.poll().intValue();
    }

    // 动态规划
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int m = primes.length;
        int[] dp = new int[n + 1];
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        dp[1] = 1;
        for (int i = 2; i <=n; i++) {
            int min = Integer.MAX_VALUE;
            int[] nums = new int[m];
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                min = Math.min(min, nums[j]);
            }
            dp[i] = min;
            // 移动pointer指向dp的下标
            for (int j = 0; j < m; j++) {
                if (dp[i] == nums[j]) pointers[j]++;
            }
        }
        return dp[n];
    }
}
