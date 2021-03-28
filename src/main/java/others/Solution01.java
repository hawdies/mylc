package others;

/**
 * @author hawdies
 * @Date 2021/3/18
 **/
public class Solution01 {
    public static void main(String[] args) {
        int[] buttons = {1};
        long res = findMaxButtons(buttons);
        System.out.println(res);
    }

    public static long findMaxButtons(int[] buttons) {
        if (buttons == null || buttons.length == 0) return 0;
        long res = 0;
        int n = buttons.length;
        int[] dp = new int[n];
        if (n == 1) return buttons[0];
        dp[0] = buttons[0] - 1;
        for (int i = 1; i < n - 1; i++) {
            int count = buttons[i] - 1;
            dp[i] = count * (i + 1);
        }
        dp[n - 1] = buttons[n - 1] * buttons.length;
        for (int temp : dp) {
            res += temp;
        }
        return res;
    }
}
