package wexa.saima.shunfeng;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/9/6
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]= in.nextInt();
            }
            fun(arr, n);
        }
    }

    private static void fun(int[] arr, int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = 0;
            }
        }

    }

}
