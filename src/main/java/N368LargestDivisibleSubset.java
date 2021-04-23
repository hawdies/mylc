import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 * 思路: 动态规划求解
 *
 * @author hawdies
 * @date 2021/4/23
 **/
public class N368LargestDivisibleSubset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8};
        List<Integer> integers = largestDivisibleSubset(nums);
        System.out.println(integers);
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        // dp[i]表示以nums[i]为结尾元素的最大的整除子集
        for (int i = 1; i < n; i++) {
            int count = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) count = Math.max(count, dp[j] + 1);
            }
            dp[i] = count;
        }
        int maxSize = 1;
        int maxSizeIndex = 0;
        // 找到最大的整除子集
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxSize) {
                maxSizeIndex = i;
                maxSize = dp[i];
            }
        }
        // 找到最大整除子集中的每一个元素(这是一个递归查找的过程);
        int maxValue = nums[maxSizeIndex];
        list.add(maxValue);
        maxSize--;
        for (int i = maxSizeIndex - 1; i >= 0; i--) {
            if (maxSize == dp[i] && maxValue % nums[i] == 0) {
                maxValue = nums[i];
                list.add(maxValue);
                maxSize--;
            }
        }
        return list;
    }
}
