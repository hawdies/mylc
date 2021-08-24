package wexa.newcoder.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int m = in.nextInt();
                int weight = in.nextInt();
                int[] arr = new int[m];
                for (int j = 0; j < m; j++) {
                    arr[j] = in.nextInt();
                }
                fun(arr, m, weight);
            }
        }
    }

    private static void fun(int[] arr, int m, int weight) {
        Arrays.sort(arr);
        int minShip = 0;
        int[] arr1 = new int[m];
        int[] arr2 = new int[m];
        int k1 = 0;
        int k2 = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] % 2 == 0) {
                arr1[k1++] = arr[i];
            } else {
                arr2[k2++] = arr[i];
            }
        }
        if (k1 > 1) {
            for (int j = k1 - 1; j >= 0; j--) {
                if (j > 0 && arr1[j] + arr1[0] <= weight) {
                    minShip += (j + 1) / 2 + (j + 1) % 2;
                    break;
                } else {
                    minShip++;
                }
            }
        } else {
            minShip += k1;
        }

        if (k2 > 1) {
            for (int j = k2 - 1; j >= 0; j--) {
                if (j > 0 && arr2[j] + arr2[0] <= weight) {
                    minShip += (j + 1) / 2 + (j + 1) % 2;
                    break;
                } else {
                    minShip++;
                }
            }
        } else {
            minShip += k2;
        }
        System.out.println(minShip);
    }
}
