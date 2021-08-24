package wexa.newcoder.tencent;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            String str = in.next();
            fun(str, n, m);
        }
    }

    private static void fun(String str, int n, int m) {
        char[] chars = str.toCharArray();
        char[] res = new char[m];
        int index = -1;
        for (int i = 0; i < m; i++) {
            for (int j = index + 1; j < n - m + i + 1; j++) {
                if (res[i] < chars[j]) {
                    res[i] = chars[j];
                    index = j;
                }
            }
        }
        System.out.println(new String(res));
    }
}
