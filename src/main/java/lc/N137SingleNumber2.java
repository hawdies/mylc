package lc;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 思路: 通过统计每位中1出现的次数,然后对3取余,最后的结果就是只出现1次的数字
 * @author hawdies
 * @date 2021/4/30
 **/
public class N137SingleNumber2 {
    public static void main(String[] args) {
        int[] nums = {30000,500,100,30000,100,30000,100};
        N137SingleNumber2 n137SingleNumber2 = new N137SingleNumber2();
        int i = n137SingleNumber2.singleNumber(nums);
        System.out.println(i);

    }
    public int singleNumber(int[] nums) {
        int[] digits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                digits[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }

        for (int i = 0; i < 32; i++) {
            digits[i] %= 3;
        }

        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= digits[i] << i;
        }
        return res;
    }
}
