package lc;

import java.util.Arrays;

/**
 * description: 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余后返回。
 *
 * 思路: 求出差值数组, 然后对每个插值遍历可以替换的值,使用二分查找可将遍历时间复杂度降为O(logn),遍历每个插值,总的时间复杂度为O(nlogn)
 *
 * @author hawdies
 * @date 2021/7/14
 **/
public class N1818MinimumAbsoluteSumDifference {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] diff = new int[n];
        final int MOD = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
        }
        int[] copyNums1 = Arrays.copyOf(nums1, n);
        Arrays.sort(copyNums1);
        long minSumDiff = 0;
        for (int e : diff) {
            minSumDiff = minSumDiff + e;
        }
        long res = minSumDiff;
        for (int i = 0; i < n; i++) {
            int newDiff;
            int index = Arrays.binarySearch(copyNums1, nums2[i]);
            if (index >= 0) {
                newDiff = 0;
            } else {
                index = -index - 1;
                if (index == n) {
                    index = n - 1;
                } else if (index > 0) {
                    index = Math.abs(nums2[i] - copyNums1[index]) <= Math.abs(nums2[i] - copyNums1[index - 1]) ? index : index - 1;
                }
                newDiff = Math.abs(nums2[i] - copyNums1[index]);
            }
            res = Math.min(res, minSumDiff - diff[i] + newDiff);
        }

        return (int) (res % MOD);
    }
}
