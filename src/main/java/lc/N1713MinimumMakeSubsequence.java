package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * description:
 * 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
 * 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
 * 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
 * 一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 * <p>
 * 思路: 本题为求最长公共子序列(LCS问题),可参考{@link N1143LongestCommonSubsequence}, 使用动态规划求解,时间复杂度O(mn);
 * 由于题目target是互不相同整数,可以将其映射为下标, 然后将arr数组中对应元素映射为下标,转为求解arr下标数组中最长严格递增子序列问题(LIS问题). 时间复杂度为O(nlgn).
 * <p>
 * tips: 对于arr中不在target数组元素中的小标映射为无效值,求解时过滤,或者直接剔除.
 * 对于LIS问题中,求解出第一个大于等于目标值的元素,使用改进的二分查找.见下:
 *
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
public class N1713MinimumMakeSubsequence {
    public int minOperations(int[] target, int[] arr) {
        int m = target.length;
        int n = arr.length;
        int[] arr2 = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            map.put(target[i], i);
        }
        for (int j = 0; j < n; j++) {
            int index = map.getOrDefault(arr[j], -1);
            arr2[j] = index;
        }

        int len = lengthOfLIS(arr2);
        return m - len;
    }

    private int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i < n && arr[i] == -1) i++;
        if (i == n) return 0;
        int[] dp = new int[n];
        int len = 1;
        dp[0] = arr[i];
        for (i = i + 1; i < n; i++) {
            if (arr[i] == -1) continue;
            if (arr[i] > dp[len - 1]) {
                dp[len] = arr[i];
                len++;
            } else {
                int l = 0;
                int r = len - 1;
                int index = getFirstGreatThanIndex(dp, l, r, arr[i]);
                dp[index] = arr[i];
            }
        }
        return len;
    }

    private int getFirstGreatThanIndex(int[] arr, int l, int r, int target) {
        while (l < r) {
            int mid = l + r >>> 1;
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
