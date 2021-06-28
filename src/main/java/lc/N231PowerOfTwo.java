package lc;

/**
 * @author hawdies
 * @date 2021/5/31
 **/
public class N231PowerOfTwo {
    /**
     * 方法1:lowbit算法. lowbit(n) = n ^ -n, 表示: 数字n按位,最右边的1所表示的数字
     *
     * 方法2: 通过n & (n -1) == 0来判断是否为2的幂. n & (n - 1)表示将二进制表示中的最右边的1变为0,所表示的数字.
     *
     * @param n
     * @return 判断n是否为2的幂
     */
    public boolean isPowerOfTwo(int n) {
        // 方法1
        return n > 0 && (n & -n) == n;
        // 方法2
//        return n > 0 && (n & (n - 1));
    }
}
