package wexa.newcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution5 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            fun(arr, n);
        }
    }

    private static void fun(int[] arr, int n) {
        Arrays.sort(arr);
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            int value = arr[i];
            long tmp = 0;
            for (int j = 0; j < n; j++) {
                if (j > 0 && arr[j] == arr[j - 1]) continue;
                tmp += Math.abs(arr[j] - value);
            }
            min = Math.min(min, tmp);
        }
        System.out.println(min);
    }
}
