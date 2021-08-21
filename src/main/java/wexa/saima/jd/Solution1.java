package wexa.saima.jd;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/21
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
            }
            fun1(arr, n);
        }
    }

    private static void fun(int[][] arr, int n) {
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = Math.abs(arr[i][0] - arr[j][0]);
                int b = Math.abs(arr[i][1] - arr[j][1]);
                if (a == b) res++;
            }
        }
        System.out.println(res);
    }

    private static void fun1(int[][] arr, int n) {
        int[][] map = new int[1000][1000];
        for (int i = 0; i < n; i++) {
            map[arr[i][0] - 1][arr[i][1] - 1] = 1;
        }
        int[][] dp = new int[2][2000];
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if (map[i][j] == 1) {
                    if (i <= j) {
                        dp[0][j - i]++;
                    } else {
                        dp[0][i - j + 1000]++;
                    }
                    dp[1][j + i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2000; j++) {
                if (dp[i][j] > 1) {
                    res += dp[i][j] * (dp[i][j] - 1) / 2;
                }
            }
        }
        System.out.println(res);
    }
}
