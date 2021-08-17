package lc;

/**
 * description: 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 思路:
 * 根据题目要求，我们需要统计 [0, n]范围内所有整数中，数字1出现的个数。
 * 我们可以考虑枚举每一个数位，分别统计该数位上数字 1 出现的次数，最后将所有数位统计出的次数进行累加即可得到答案。
 * 为了直观地叙述我们的算法，下面我们以「百位」进行举例，对于几个不同的n手动计算出答案，随后扩展到任意数位。
 * 以 n=1234567 为例，我们需要统计「百位」上数字 1 出现的次数。我们知道，对于从 0 开始每 1000个数，「百位」上的数字 1 都会出现 100次，
 * 即数的最后三位每 1000 个数都呈现 [000, 999]的循环，其中的 [100, 199]在「百位」上的数字为 1，共有 100个。
 * n 拥有 12341234 个这样的循环，每个循环「百位」上都出现了 100 次 1，这样就一共出现了1234×100 次 1。
 *

 * @author hawdies
 * @date 2021/8/13
 **/
public class N233NumberOfDigitOne {
    public int countDigitOne(int n) {
        int mulk = 1;
        int ans = 0;
        for (int i = 0; mulk <= n; i++) {
            ans += n / (mulk * 10) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }
}