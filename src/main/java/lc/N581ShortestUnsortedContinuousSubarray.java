package lc;

import java.util.Arrays;

/**
 * description: 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * @author hawdies
 * @date 2021/8/3
 **/
public class N581ShortestUnsortedContinuousSubarray {
    // 排序,比较
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] copy = new int[n];
        System.arraycopy(nums, 0, copy, 0, n);
        Arrays.sort(copy);
        int first = 0;
        int last = n - 1;
        while (first < n) {
            if (nums[first] != copy[first]) {
                break;
            }
            first++;
        }
        while (last >= 0) {
            if (nums[last] != copy[last]) {
                break;
            }
            last--;
        }
        int count = 0;
        if (first < n && last >= first) {
            count = last - first + 1;
        }
        return count;
    }

    // 双指针,找到left, right边界
    public int findUnsortedSubarray02(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > maxn) {
                maxn = nums[i];
            } else {
                right = i;
            }
            if (nums[n - i - 1] < minn) {
                minn = nums[n - i - 1];
            } else {
                left = n - i - 1;
            }
        }
        return right == - 1 ? 0 : right - left + 1;
    }
}
