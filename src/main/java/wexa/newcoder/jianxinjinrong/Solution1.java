package wexa.newcoder.jianxinjinrong;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2021/9/17
 **/
public class Solution1 {
    public static void main(String[] args) {
        Solution1 demo = new Solution1();
        int res = demo.reversePlus(12, 13);
        System.out.println(res);
    }
    public int reversePlus (int a, int b) {
        int a0 = a;
        int b0 = b;
        int c = 0;
        int d = 0;
        while (a0 > 0) {
            int ys = a0 % 10;
            a0 = a0 / 10;
            c = c * 10 + ys;
        }
        while (b0 > 0) {
            int ys = b0 % 10;
            b0 = b0 / 10;
            d = d * 10 + ys;
        }
        int[] arr = {a + b, a + d, c + b, c + d};
        Arrays.sort(arr);
        return arr[3];
    }
}
