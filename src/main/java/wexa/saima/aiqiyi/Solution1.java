package wexa.saima.aiqiyi;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] split = s.split(",");
            int n = split.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            fun(arr, n);
        }
    }

    private static void fun(int[] arr, int n) {
        if (n == 1) System.out.println(0);
        int minDiff = 0;
        int high = arr[0];
        int low = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                high = arr[i];
            } else {
                low = arr[i];
            }
            minDiff = Math.max(minDiff, Math.abs(high - low));
        }
        System.out.println(minDiff);
    }
}
