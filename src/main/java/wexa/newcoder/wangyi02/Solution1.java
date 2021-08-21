package wexa.newcoder.wangyi02;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/21
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int m = scanner.nextInt();
            String[] s = str.split(" ");
            int[] arr = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            fun(arr, m);
        }

    }

    private static void fun(int[] arr, int m) {
        Arrays.sort(arr);
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = n - 1;
            int mid = fun02(arr, i, j, m);
            if (i < mid)
                res += mid - i;
        }
        System.out.println(res);
    }

    private static int fun02(int[] arr, int left, int right, int m) {
        if (arr[left] + arr[right] <= m) return right;
        while (left < right && arr[left] + arr[right] > m) {
            right--;
        }
        return right;
    }
}
