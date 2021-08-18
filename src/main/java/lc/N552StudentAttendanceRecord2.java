package lc;

/**
 * description: 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 *
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。
 *
 * 思路: dp[i][j][k] 表示i个字符,其中'A'一共有j个,并且以'L'结尾,尾部有连续的k个'L'
 * @author hawdies
 * @date 2021/8/18
 **/
public class N552StudentAttendanceRecord2 {
    public int checkRecord(int n) {
        // dp[i][j][k] 表示i个字符,其中'A'一共有j个,并且以'L'的结尾,尾部有连续的k个'L'
        int[][][] dp = new int[n + 1][2][3];
        final int MOD = (int)(1e9 + 7);
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            // 以p结尾
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i - 1][j][k]) % MOD;
                }
            }

            // 以L结尾
            for (int j = 0; j < 2; j++) {
                dp[i][j][1] = (dp[i][j][1] + dp[i - 1][j][0]) % MOD;
                dp[i][j][2] = (dp[i][j][2] + dp[i - 1][j][1]) % MOD;
            }

            // 以A结尾
            for (int k = 0; k < 3; k++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][k]) % MOD;
            }
        }

        int res = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                res = (res + dp[n][j][k]) % MOD;
            }
        }

        return res;
    }
}
