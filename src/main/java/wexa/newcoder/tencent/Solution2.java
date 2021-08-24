package wexa.newcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                int[] arr = new int[m];
                for (int j = 0; j < m; j++) {
                    arr[j] = in.nextInt();
                }
                fun(arr, m);
            }
        }
    }

    private static void fun(int[] arr, int m) {
        final int MOD = 1000000007;
        Arrays.sort(arr);
        long res = 0;
        long add = 0;
        for (int i = m - 1; i >= 0; i--) {
            add = (add + arr[i]) % MOD;
            res = ((res + arr[i]) % MOD + add * i % MOD) % MOD;
        }
        System.out.println(res);
    }
}
