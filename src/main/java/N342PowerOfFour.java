/**
 *
 * description: 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4^x
 *
 * 思路: 转换为先开方,再转换为求解2的幂
 *
 * @author hawdies
 * @date 2021/5/31
 **/
public class N342PowerOfFour {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) return false;
        int q =  (int) Math.sqrt(n);
        return q * q == n && (q & -q) == q;
    }
}
