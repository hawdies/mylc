package lc;

import java.util.Arrays;

/**
 * description: 给你一个正整数数组arr。请你对 arr执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * arr中 第一个元素必须为1。
 * 任意相邻两个元素的差的绝对值 小于等于1，也就是说，对于任意的 1 <= i < arr.length（数组下标从 0 开始），都满足abs(arr[i] - arr[i - 1]) <= 1。abs(x)为x的绝对值。
 * 你可以执行以下 2 种操作任意次：
 * 减小 arr中任意元素的值，使其变为一个 更小的正整数。
 * 重新排列arr中的元素，你可以以任意顺序重新排列。
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr中可能的 最大值。
 * <p>
 * 思路: 排序后按规则求解
 * 时间复杂度O(nlogn)
 *
 * @author hawdies
 * @date 2021/7/15
 **/
public class N1814MaximumByRuleRearranging {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}
