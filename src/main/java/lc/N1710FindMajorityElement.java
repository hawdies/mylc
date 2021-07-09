package lc;

/**
 * description: 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 *
 * @author hawdies
 * @date 2021/7/9
 **/
public class N1710FindMajorityElement {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int num = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
                count++;
            } else {
                count = num == nums[i] ? count + 1 : count - 1;
            }
        }
        count = 0;
        for (int j : nums) {
            if (j == num) count++;
        }
        if (count > nums.length / 2) return num;
        return -1;
    }

}
