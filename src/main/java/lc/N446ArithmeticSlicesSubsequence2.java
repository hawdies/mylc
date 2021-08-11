package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。
 * 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。
 * 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
 * 再例如，[1, 1, 2, 5, 7] 不是等差序列。
 * 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。
 * 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
 * 题目数据保证答案是一个 32-bit 整数。
 * <p>
 * 思路:动态规划求解
 * dp[i][d]表示尾项为nums[i], 公差为d的弱等差序列.(弱等差序列: 只有两项的等差序列)
 * 对nums数组进行双层遍历
 * i表示以nums[i]为尾项,j表示一nums[j]为倒数第二项,同时d = nums[i] - nums[j]为公差.
 * dp[j][d]就是以nums[i]为尾项,d为公差的实际等差序列个数.因为dp[j][d]是弱等差序列个数,再加上nums[i]刚好构成了等差序列.
 * 由于公差d范围很大(可能超过int范围,故使用long),因此第二维使用哈希,整个结构使用哈希数组.
 *
 * @author hawdies
 * @date 2021/8/11
 **/
public class N446ArithmeticSlicesSubsequence2 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        Map<Long, Integer>[] maps = new Map[n];
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                Integer value = maps[j].getOrDefault(diff, 0);
                res += value;
                maps[i].put(diff, maps[i].getOrDefault(diff, 0) + value + 1);
            }
        }
        return res;
    }
}
