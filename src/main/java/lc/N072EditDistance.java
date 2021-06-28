package lc;

/**
 * @author hawdies
 * @date 2021/4/28
 **/
public class N072EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        int i = minDistance(word1, word2);
        System.out.println(i);

    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int num = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                dp[i][j] = Math.min(dp[i - 1][j - 1] + num, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }

        return dp[m][n];
    }

    // 优化二维数组为一维数组
    public static int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];
        int leftRight = 0;
        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }
        for (int i = 1; i <= m; i++) {
            leftRight = dp[0];
            dp[0] = i;
            for (int j = 1; j <= n; j++) {
                int num = word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1;
                int temp = dp[j];
                dp[j] = Math.min(leftRight + num, Math.min(dp[j] + 1, dp[j - 1] + 1));
                leftRight = temp;
            }
        }

        return dp[n];
    }

}
