package lc;

import java.util.Arrays;

/**
 * description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 思路1: 动态规划求解, 时间复杂度O(n^2)
 * <p>
 * 思路2: 贪心算法 + 二分, 时间复杂度O(nlgn). 只要使递增的幅度最小,那么递增的长度就是最大的.具体就是每次添加到尾端的元素是最小增长.
 * 使用数组dp[i]表示最长严格递增子序列最后一个元素的值,len表示最长子序列的长度.
 * 初始值为dp[0] = nums[0], len = 1;
 * 然后开始从index = 1开始遍历nums数组
 * 遍历到下标为i时:
 * 如果nums[i] > dp[len - 1], 则将nums[i]添加到dp的尾部,然后len++;
 * 否则,使用二分查找找到dp[0...len-1]中第一个大于等于nums[i]的数替换掉.
 * <p>
 * tips: 使用此种方法构造出的dp[]数组一定时严格递增,故可以用二分查找.
 * 因为是要严格单调递增所以要使用">="来替换,如果是非严格递增,则可以用">"来替换.
 *
 * 二分查找大于target的第一个数的下标:
 * <pre>{@code
 * private int getFirstGreatThanIndex(int[] arr, int l, int r, int target) {
 *         while (l < r) {
 *             int mid = l + r >>> 1;
 *             if (arr[mid] < target) {
 *                 l = mid + 1;
 *             } else {
 *                 r = mid;
 *             }
 *         }
 *         return l;
 *     }
 * }
 *
 * @author hawdies
 * @date 2021/7/26
 **/
public class N300LongestIncresingSubsequence {

    public static void main(String[] args) {
        int[] nums = {4, 10, 4, 3, 8, 9};
        N300LongestIncresingSubsequence demo = new N300LongestIncresingSubsequence();
        int k = demo.lengthOfLIS02(nums);
        System.out.println(k);
    }

    // 动态规划求解
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    // 贪心 + 二分查找
    public int lengthOfLIS02(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            } else {
                int l = 0;
                int r = len - 1;
                int mid = l;
                while (l <= r) {
                    mid = l + r >>> 1;
                    if (dp[mid] == nums[i]) break;
                    else if (dp[mid] > nums[i]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
                while (mid < len - 1 && dp[mid] < nums[i]) mid++;
                dp[mid] = nums[i];
            }
        }
        return len;
    }
}
