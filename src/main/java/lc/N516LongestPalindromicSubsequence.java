package lc;

/**
 * description:
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 思路: 使用动态规划求解
 * dp[i][j]: 以s[i..j]字符串的最长回文子序列.
 * 0 <= i < j <= n - 1;
 * 初始条件: dp[i][i] = 1;
 * i需要从n-1开始遍历.
 * 当s[i] == s[j] dp[i][j] = dp[i + 1][j - 1] + 2;
 * 当s[i] != s[j] dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j])
 * 返回dp[0][n - 1];
 *
 * @author hawdies
 * @date 2021/8/12
 **/
public class N516LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "cbbd";
        N516LongestPalindromicSubsequence demo = new N516LongestPalindromicSubsequence();
        int i = demo.longestPalindromeSubseq(s);
        System.out.println(i);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
