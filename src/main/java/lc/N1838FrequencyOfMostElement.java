package lc;

import java.util.Arrays;

/**
 * description:元素的 频数 是该元素在一个数组中出现的次数。
 * 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。
 * 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
 * <p>
 * 思路: 排序 + 滑动窗口;
 * tips: 记录好左边界,统计改变总数total
 *
 * @author hawdies
 * @date 2021/7/19
 **/
public class N1838FrequencyOfMostElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 1;
        int left = 0;
        int total = 0;
        for (int i = 1; i < n; i++) {
            total += (nums[i] - nums[i - 1]) * (i - left);
            while (left <= i && total > k) {
                total -= nums[i] - nums[left];
                left++;
            }
            count = Math.max(count, i - left + 1);
        }
        return count;
    }
}
