package lc;

/**
 * 问题描述: 给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点
 * <p>
 * 解题思路: 按位与,只要有一个为0,则为0.(可以从简单例子分析其规律)
 * 实质为求解公共前缀,后面补0.<br>
 * <a href="https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/">
 * 详见题解</a>
 *
 * @author hawdies
 * @date 2021/4/14
 **/
public class N201BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            shift++;
            left >>>= 1;
            right >>>= 1;
        }
        left <<= shift;
        return left;
    }
}
