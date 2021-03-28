import java.util.List;

/**
 * @author hawdies
 * @Date 2021/3/24
 **/
public class N139WorkBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        // dp求解
        s = s.trim();
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i]) break;
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
            }
        }
        return dp[n];
    }
}
