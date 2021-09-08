package wexa.saima.xiaomi;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/9/8
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] splits = s.split(" +");
            int n = splits.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(splits[i]);
            }
            fun(arr, n);
        }
    }

    private static void fun(int[] arr, int n) {
        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                k1++;
            } else if (arr[i] == 2) {
                k2++;
            } else {
                k3++;
            }
        }
        int index = 0;
        while (k1 > 0) {
            arr[index++] = 1;
            k1--;
        }
        while (k2 > 0) {
            arr[index++] = 2;
            k2--;
        }
        while (k3 > 0) {
            arr[index++] = 3;
            k3--;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
}
