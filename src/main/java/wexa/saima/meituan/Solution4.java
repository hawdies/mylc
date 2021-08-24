package wexa.saima.meituan;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = in.nextInt();
            }
            int m = in.nextInt();
            int[][] arr = new int[m][3];
            for (int i = 0; i < m; i++) {
                arr[i][0] = in.nextInt();
                arr[i][1] = in.nextInt();
                arr[i][2] = in.nextInt();
            }
            fun(data, n, arr, m);
        }
    }

    private static void fun(int[] data, int n, int[][] arr, int m) {
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int l = arr[i][1];
            int r = arr[i][2];
            if (arr[i][0] == 1) {
                System.out.println(sum[r] - sum[l - 1]);
            } else if (arr[i][0] == 2) {
                long res = 0;
                for (int j = l; j <= r; j++) {
                    long num = sum[r] - sum[l - 1]- data[j - 1];
                    res += num * num;
                }
                System.out.println(res);
            } else {
                int max = Integer.MIN_VALUE;
                for (int j = l - 1; j < r; j++) {
                    max = Math.max(max, data[j]);
                }
                System.out.println(max);
            }
        }
    }
}
