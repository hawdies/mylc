package lc;

/**
 * description: 向数组中的每个整数前添加+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 思路1: 使用回溯求解,时间复杂度O(2^n)
 * 思路2: 使用动态规划求解
 *
 * @author hawdies
 * @date 2021/6/7
 **/
public class N494TargetSum {
    // 动态规划求解
    // 需要注意初始条件,nums[i]为0的情况
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2001];
        // 初始条件
        dp[0][1000] = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = nums[i - 1];
            for (int j = 0; j < 2001; j++) {
                if (tmp == 0) {
                    // +0, -0算两种情况
                    dp[i][j] = dp[i - 1][j] * 2;
                } else {
                    dp[i][j] = (j - tmp >= 0 ? dp[i - 1][j - tmp] : 0) + (j + tmp <= 2000 ? dp[i - 1][j + tmp] : 0);
                }
            }
        }
        return dp[n][1000 + target];
    }

    // 回溯求解,递归求解
    private int count = 0;

    public int findTargetSumWays02(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }


}
