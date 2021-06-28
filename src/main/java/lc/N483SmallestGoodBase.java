package lc;

/**
 * description: 对于给定的整数 n, 如果n的k（k>=2）进制数的所有数位全为1，则称k（k>=2）是 n 的一个好进制。
 *
 * 以字符串的形式给出 n, 以字符串的形式返回 n 的最小好进制。
 *
 *
 * 思路: 纯数学问题,需要较强的数学思维.需要根据进制转换公式计算出原数字n, 进制数k, 以及位数m之间的关系.确定k的范围,然后遍历.
 * 问题较难,一般也不会遇到.可略过.
 *
 * @author hawdies
 * @date 2021/6/18
 **/
public class N483SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) (Math.log(nVal) / Math.log(2));
        for (int i = mMax; i >= 2; i--) {
            int k = (int) (Math.pow(nVal, 1.0 / i));
            long mul = 1;
            long sum = 1;
            for (int j = 0; j < i; j++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }
}
