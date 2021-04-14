/**
 * descirption: 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 思路:记录当前元素的前缀积和和后缀积,最后相乘.注意边界中单位元是1
 *
 * @author hawdies
 * @Date 2021/3/31
 **/
public class N238ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int[] sum = new int[n];
        dp1[0] = 1; // 前缀积
        dp1[1] = nums[0];
        dp2[n - 1] = 1; // 后缀积
        dp2[n - 2] = nums[n - 1];
        for (int i = 2; i < n; i++) {
            dp1[i] = nums[i - 1] * dp1[i - 1];
            dp2[n - i - 1] = nums[n - i] * dp2[n - i];
        }

        for (int i = 0; i < n; i++) {
            sum[i] = dp1[i] * dp2[i];
        }
        return sum;
    }
}
