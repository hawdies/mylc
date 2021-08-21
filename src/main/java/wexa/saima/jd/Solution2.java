package wexa.saima.jd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/21
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String s = in.next();
            fun(s, n);
        }
    }

    private static void fun(String s, int n) {
        int[] arr = new int[n];
        int[][] sum = new int[n + 1][2];
        Arrays.fill(arr, 1);
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '0') {
                sum[i][0] = sum[i - 1][0] + 1;
                sum[i][1] = sum[i - 1][1];
            } else {
                sum[i][1] = sum[i - 1][1] + 1;
                sum[i][0] = sum[i - 1][0];
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int num0 = sum[i][0] - sum[j][0];
                int num1 = sum[i][1] - sum[j][1];
                if (num0 * sum[j][1] == num1 * sum[j][0]) {
                    arr[i - 1]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
