package wexa.newcoder.beikezufang;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2021/8/13
 **/
public class Solution1 {

    public static void main(String[] args) {
        int n = 2;
        long m = 5L;
        Solution1 demo = new Solution1();
        long[] longs = demo.FarmerNN(n, m);
        System.out.println(Arrays.toString(longs));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param n int整型
     * @param m long长整型
     * @return long长整型一维数组
     */
    public long[] FarmerNN (int n, long m) {
        // write code here
        long[] res = new long[n];
        if (m <= n) {
            for (long i = 0; i < m; i++) {
                res[(int)i] = 1;
            }
            return res;
        }

        long k = (m - 1) / (n - 1);
        long ys = m - k * (n - 1) - 1;
        Arrays.fill(res, k);
        res[0] -=((k - 1) / 2);
        res[n - 1] -= (k / 2);
        if (k % 2 == 0) {
            for (long i = 1; i <= ys; i++) {
                res[(int)i]++;
            }
        } else {
            for (long i = n - 2; ys > 0; i--) {
                res[(int)i]++;
                ys--;
            }
        }
        return res;
    }
}
