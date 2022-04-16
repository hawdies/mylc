package lc;

/**
 * @author hawdies
 * @date 2022/4/16
 */
public class N479LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        final int M = (int) Math.pow(10, n) - 1;
        for (int i = M; i > M / 10; i--) {
            long left = i, right = i;
            while (right > 0) {
                left = left * 10 + right % 10;
                right /= 10;
            }
            long p = M; //必须为 long
            while (p * p >= left) {
                if (left % p == 0) {
                    return (int)left % 1337;
                }
                p--;
            }
        }
        return 0;
    }
}
