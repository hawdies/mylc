package lc;

/**
 * description: 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * 思路: 分两次进行dp,[0, n-1], [1, n]两种
 *
 * @author hawdies
 * @date 2021/4/22
 **/
public class N213HouseRobber2 {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(findMaxValue(nums, 0, nums.length - 2), findMaxValue(nums, 1, nums.length - 1));
    }

    private int findMaxValue(int[] nums, int l, int r) {
        int dp0 = nums[l];
        int dp1 = Math.max(nums[l], nums[l + 1]);
        // 有可能只有两个元素,故不能初始化为dp2 = 0;
        int dp2 = Math.max(dp0, dp1);
        for (int i = l + 2; i <= r; i++) {
            dp2 = Math.max(dp1, dp0 + nums[i]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }

}
