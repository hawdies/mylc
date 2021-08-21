package wexa.newcoder.wangyi02;

import java.util.Arrays;

/**
 * @author hawdies
 * @date 2021/8/21
 **/
public class Solution2 {

    private static String invert(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            char n = (char) (25 - (c - 'a') + 'a');
            chars[i] = n;
        }
        return new String(chars);
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回Sn的第k位字符
     *
     * @param n int整型 Sn的n
     * @param k int整型 需要返回的字符下标位
     * @return char字符型
     */
    public char findKthBit(int n, int k) {
        String dp = "a";
        for (int i = 1; i < 24; i++) {
            char cur = (char) ('a' + i);
            dp = dp + cur + reverse(invert(dp));
        }
        int num = 1;
        for (int i = 2; i < 25; i++) {
            num = 2 * num + 1;
        }
        if (k <= num)
            return dp.charAt(k - 1);
        if (k == num + 1) return 'y';
        int num2 = k - num - 1;
        int index = num - num2;
        char c = dp.charAt(index - 1);
        return (char) (25 - (c - 'a') + 'a');

    }

    public static void main(String[] args) {
//        Solution2 demo = new Solution2();
//        char kthBit = demo.findKthBit(26, 1);
//        System.out.println(kthBit);

        String s = "fsadf fasf fsaf  fdsf    fasf";
        String[] split = s.split(" +");
        System.out.println(Arrays.toString(split));
    }

}
