package wexa.newcoder.ali;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/20
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] arr = new int[m][2];
            for (int i = 0; i < m; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
            }
            fun(arr, n, m);
        }

    }

    private static void fun(int[][] arr, int n, int m) {

    }
}
