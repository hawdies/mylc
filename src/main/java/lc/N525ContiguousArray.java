package lc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * description: 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度
 *
 * 思路: 前缀和 + 哈希表
 * 将 0 用 -1 表示,即可将问题转换为求解和为0的最长子序列
 * 然后用hash表存储前缀和对应的nums数组的最小小标即可
 * @author hawdies
 * @date 2021/6/3
 **/
public class N525ContiguousArray {
    // 前缀和 + 哈希表
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        // 边界处理
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            if (map.containsKey(sums[i])) {
                ans = Math.max(ans, i - map.get(sums[i]));
            } else {
                map.put(sums[i], i);
            }
        }
        return ans;
    }

    // 前缀和 + 模拟哈希表
    public int findMaxLength2(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }
        // 模拟hash表
        // hash数组的下表表示前缀和的范围,值表示相应前缀和的值第一次出现时nums的下标
        // 由于前缀和的取值范围为[-n, n],故需要2 * n + 1个位置
        int[] hash = new int[2 * n + 1];
        Arrays.fill(hash, -1);
        hash[n] = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (hash[sums[i] + n] == -1) {
                hash[sums[i] + n] = i;
            } else {
                ans = Math.max(ans, i - hash[sums[i] + n]);
            }
        }
        return ans;
    }
}
