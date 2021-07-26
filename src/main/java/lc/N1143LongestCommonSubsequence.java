package lc;

/**
 * description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 思路: 二维动态规划求解
 *
 * @author hawdies
 * @date 2021/7/26
 **/
public class N1143LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";
        N1143LongestCommonSubsequence demo = new N1143LongestCommonSubsequence();
        int res = demo.longestCommonSubsequence(text1, text2);
        System.out.println(res);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int res = 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + 1);
                }
                res = Math.max(res, dp[i + 1][j + 1]);
            }
        }
        return res;
    }
}
