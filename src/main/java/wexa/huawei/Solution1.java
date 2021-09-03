package wexa.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/9/1
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] arr = new int[n][2];
            in.nextLine();
            String str = in.nextLine();
            String[] s = str.split(" ");
            for (int i = 0; i < n; i++) {
                String[] split = s[i].split(",");
                arr[i][0] = Integer.parseInt(split[0]);
                arr[i][1] = Integer.parseInt(split[1]);
            }
            int a = in.nextInt();
            fun(arr, n, a);
        }
    }

    private static void fun(int[][] arr, int n, int a) {
        List<int[]> list = new ArrayList<>();
        int k = -1;
        for (int i = 0; i < n; i++) {
            if (!list.isEmpty()) {
                int[] pre = list.get(list.size() - 1);
                if (pre[0] > arr[i][0] && pre[1] > arr[i][1]) {
                    if (k + 1 != i) {
                        list.remove(list.size() - 1);
                        k = i;
                    }
                }
            }
            list.add(new int[]{arr[i][0], arr[i][1]});
        }

        int[][] res = new int[list.size()][2];
        int[] ints = list.get(0);
        res[0][0] = Math.min(a, ints[0]);
        if (a - res[0][0] <= 0) {
            res[0][1] = 0;
        } else {
            res[0][1] = Math.min(a - res[0][0], ints[1]);
        }
        int result = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] ints2 = list.get(i);
            res[i][0] = Math.min(res[i - 1][0], ints2[0]);
            if (res[i - 1][0] - res[i][0] <= 0) {
                res[i][1] = 0;
            } else {
                res[i][1] = Math.min(res[i - 1][0] - res[i][0], ints2[1]);
            }
        }
        result = res[list.size() - 1][0];

        res[0][0] = res[0][1];
        for (int i = 1; i < list.size(); i++) {
            int[] ints2 = list.get(i);
            res[i][0] = Math.min(res[i - 1][0] + res[i][1], ints2[0]);
        }
        result += res[list.size() - 1][0];
        System.out.println(result);
    }
}
