package lc;

import java.util.Arrays;

/**
 * 
 * description: 给你一个整数数组cost和一个整数target。请你返回满足如下规则可以得到的最大整数：
 *
 * 给当前结果添加一个数位（i + 1）的成本为cost[i]（cost数组下标从 0 开始）。
 * 总成本必须恰好等于target。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 *
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 *
 * 思路: 分两步求解,先用dp计算出最大的数字长度,然后根据数字长度反推路径.
 * 1. 完全背包求解,dp[i]:表示,花费成本为i所得到的数字长度(成本是选每个数字的花费,价值就是最大的数字长度)
 * 2. 根据dp[i]去反推它的路径,需要从9~1开始遍历
 * @author hawdies
 * @date 2021/6/12
 **/
public class N1449FormLargestIntegerToTarget {
    public static void main(String[] args) {
        int[] cost = {
                1, 1, 1, 1, 1, 1, 1, 3, 2
        };
        int target = 10;
        N1449FormLargestIntegerToTarget c = new N1449FormLargestIntegerToTarget();
        String s = c.largestNumber(cost, target);
        System.out.println(s);
    }

    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE / 2);
        dp[0] = 0;
        for (int i = 1; i <= 9; i++) {
            int curCost = cost[i - 1];
            for (int j = curCost; j <= target; j++) {
                dp[j] = Math.max(dp[j], dp[j - curCost] + 1);
            }
        }
        if (dp[target] < 0) return "0";

        StringBuilder ans = new StringBuilder();
        for (int i = 9, j = target; i >= 1; i--) {
            int curCost = cost[i - 1];
            for (;j >= curCost && dp[j] == dp[j - curCost] + 1; j -= curCost) {
                ans.append(i);
            }
        }
        return ans.toString();
    }
}
