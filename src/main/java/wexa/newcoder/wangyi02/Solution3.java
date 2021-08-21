package wexa.newcoder.wangyi02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/21
 **/
public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            int[] arr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            fun(arr);
        }
    }

    private static void fun(int[] arr) {
        if (arr.length == 1) {
            System.out.println(1);
            return;
        }
        if (arr.length == 2) {
            if (arr[0] == arr[1]) System.out.println(2);
            else
                System.out.println(3);
            return;
        }
        int n = arr.length;
        int[] arr2 = new int[n];
        Arrays.fill(arr2, 1);
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (arr[i] > arr[i + 1] && arr[i] > arr[n - 1]) {
                    arr2[i] = Math.max(arr2[i + 1], arr2[n - 1]) + 1;
                }
            } else if (i == n - 1) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[0]) {
                    arr2[i] = Math.max(arr2[i - 1], arr2[0]) + 1;
                }
            } else {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    arr2[i] = Math.max(arr2[i - 1], arr2[i + 1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if ((arr[i] > arr[i + 1] && arr[i] <= arr[n - 1])
                        || (arr[i] <= arr[i + 1] && arr[i] > arr[n - 1])) {
                    arr2[i] = Math.max(arr2[i + 1], arr2[n - 1]) + 1;
                }
            } else if (i == n - 1) {
                if ((arr[i] > arr[i - 1] && arr[i] <= arr[0])
                        || (arr[i] <= arr[i - 1] && arr[i] > arr[0])) {
                    arr2[i] = Math.max(arr2[i - 1], arr2[0]) + 1;
                }
            } else {
                if ((arr[i] > arr[i - 1] && arr[i] <= arr[i + 1])
                        || (arr[i] <= arr[i - 1] && arr[i] > arr[i + 1])) {
                    arr2[i] = Math.max(arr2[i - 1], arr2[i + 1]) + 1;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += arr2[i];
        }
        System.out.println(res);
    }

}
