package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * description: 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * 子数组 是数组的一段连续部分。
 *
 * 思路:
 * 方法1: 前缀和 + 哈希表, 哈希表存放的k->和, v->和出现的次数,注意起始条件应放入map.put(0, 1);
 * 方法2: 双指针
 * @author hawdies
 * @date 2021/7/8
 **/
public class N930BinarySubarraysWithSum {
    // 方法1 前缀和 + 哈希表
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        // k -> 和, v -> 出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        for (int i = 1; i < sums.length; i++) {
            int val = map.getOrDefault(sums[i] - goal, 0);
            res += val;
            map.put(sums[i], map.getOrDefault(sums[i], 0) + 1);
        }
        return res;
    }

    // 方法2 双指针 应用有局限性,只能元素非负
    public int numSubarraysWithSum02(int[] nums, int goal) {
        int l1 = 0;
        int l2 = 0;
        // s1 表示[l1, l2]的和
        int s1 = 0;
        int s2 = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            s1 += nums[r];
            s2 += nums[r];
            while (l1 <= r && s1 > goal) s1 -= nums[l1++];
            while (l2 <= r && s2 >= goal) s2 -= nums[l2++];
            res += l2 - l1;
        }
        return res;
    }
}
