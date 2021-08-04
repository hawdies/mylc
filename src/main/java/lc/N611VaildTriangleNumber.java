package lc;

import java.util.Arrays;

/**
 * description: 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]
 * <p>
 * 思路1: 三层循环遍历, 时间复杂度O(n^3)
 * 思路2: 排序 + 二分查找, 时间复杂度O(n^2log(n))
 * <p>
 * 注意:二分查找时,需要找到第一个小于target元素的下标.
 * 选取mid与常用二分有区别,使用{@code int mid = (int) Math.ceil((left + right) / 2.0);}来确定.
 * 由于可能[left, right]整个区间的值都大于target,因此需要在二分结束后最后增加一个判断
 * {@code if(nums[right] >= target) right--;}
 *
 * @author hawdies
 * @date 2021/8/4
 **/
public class N611VaildTriangleNumber {
    public static void main(String[] args) {
        N611VaildTriangleNumber demo = new N611VaildTriangleNumber();
        int[] nums = {1, 1, 3, 4};
        int i = demo.triangleNumber(nums);
        System.out.println(i);
    }

    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);
        int i = 0;
        while (i < n && nums[i] == 0) i++;
        for (; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int left = j + 1;
                int right = n - 1;
                int c = nums[i] + nums[j];
                while (left < right) {
                    int mid = (int) Math.ceil((left + right) / 2.0);
                    if (nums[mid] >= c) right = mid - 1;
                    else left = mid;
                }
                if (nums[right] >= c) right--;
                count += right - j;
            }
        }
        return count;
    }
}
