package lc;

/**
 * description: 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * 子数组 是数组中的一个连续序列。
 *
 * 思路1: 暴力求解,复杂度O(n^2)
 * 思路2: dp, 复杂度O(n)
 * @author hawdies
 * @date 2021/8/10
 **/
public class N413ArithmeticSlices {
    // dp求解
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int res = 0;
        int dp = 0;
        int diff = nums[1] - nums[0];
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == diff) {
                dp++;
            } else {
                dp = 0;
                diff = nums[i] - nums[i - 1];
            }
            res += dp;
        }
        return res;
    }

    // 暴力法求解,复杂度O(n^2)
    public int numberOfArithmeticSlices02(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int diff = nums[i + 1] - nums[i];
            if (nums[i + 2] - nums[i + 1] == diff) {
                for (int j = i + 2; j < n; j++) {
                    if (nums[j] - nums[j - 1] == diff) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }
}
