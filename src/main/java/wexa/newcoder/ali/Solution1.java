package wexa.newcoder.ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/20
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] arr = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int[][] res = fun(arr, n, k);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private static int[][] fun(int[][] arr, int n, int k) {
        int[][] res = new int[n][5];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int no = arr[i][0];
            int inout = arr[i][1];
            int level = arr[i][2];
            if (i > 0) {
                copy(res[i - 1], res[i]);
            }
            if (map.get(no) == null) {
                map.put(no, 1);
                if (i - 1 >= 0) {
                    res[i][level - 1] = res[i - 1][level - 1] + 1;
                } else {
                    res[i][level - 1]++;
                }
            } else if (map.get(no) == 2) {
                res[i][level - 1] = res[i - 1][level - 1];
                continue;
            } else {
                if (inout == 1) {
                    continue;
                } else {
                    map.put(no, 2);
                    res[i][level - 1] = res[i - 1][level - 1] - 1;
                }
            }
        }
        return res;
    }

    private static void copy(int[] arr1, int[] arr2) {
        System.arraycopy(arr1, 0, arr2, 0, arr2.length);
    }
}
