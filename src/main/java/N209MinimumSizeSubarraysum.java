/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 方法一: 滑动窗口
 * 方法二: 前缀和+二分查找
 *
 * @author hawdies
 * @date 2021/4/20
 **/
public class N209MinimumSizeSubarraysum {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }

    public int minSubArrayLen(int target, int[] nums) {
        return slideWindows(target, nums);
    }

    // 滑动窗口
    private int slideWindows(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;

            }
            end++;
        }
        return min = min == Integer.MAX_VALUE ? 0 : min;
    }

    // 前缀和 + 二分查找
    private int prefixSum(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] snums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            snums[i] = snums[i - 1] + nums[i - 1];
        }
        for (int i = 1; i < snums.length; i++) {
            int newTarget = snums[i - 1] + target;
            int end = binarySearch(newTarget, i, snums.length - 1, snums);
            end = end < 0 ? -end - 1 : end;
            if (end <= nums.length)
                min = Math.min(min, end - i + 1);
        }
        return min = min == Integer.MAX_VALUE ? 0 : min;
    }

    // 二分查找返回目标索引,如果不存在则返回"-(insertpoint)-1"
    private int binarySearch(int target, int l, int r, int[] snums) {
        while (l <= r) {
            // + 优先级高于 >>>
            int mid = l + ((r - l) >>> 1);
            if (snums[mid] == target) return mid;
            else if (snums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -l - 1;
    }
}
