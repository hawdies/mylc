import sun.util.locale.provider.FallbackLocaleProviderAdapter;

/**
 *
 * description: 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 *
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 *
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * 思路1: 使用二分法,使用一个数组,存放的元素是小于等i的个数.
 * [1, target - 1]的值均是小于target, [target, end]均是大于target,找到这样的target即可(有且只有一个)
 *
 * 思路2: 寻找环,找到环的入口即是目标
 * @author hawdies
 * @date 2021/5/31
 **/
public class N287FindDuplicateNumber {
    // 环求解
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
