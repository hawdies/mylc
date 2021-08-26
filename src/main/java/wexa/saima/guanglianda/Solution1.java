package wexa.saima.guanglianda;

import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/25
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int a1 = in.nextInt();
            int b1 = in.nextInt();
            int a2 = in.nextInt();
            int b2 = in.nextInt();
            fun(n, a1, b1, a2, b2);
        }
    }

    private static void fun(int n, int a1, int b1, int a2, int b2) {
        int num1 = 0;
        int num2 = n;
        long max = 0;
        for (int i = n; i >= 0; i--) {
            long value1 = (n - i) * a1 + i * a2;
            long value2 = (n - i) * b1 + i * b2;
            long tmp = value1 * value1 + value2 * value2;
            if (max < tmp) {
                num1 = n - i;
                num2 = i;
                max = tmp;
            }
        }
        System.out.println(num1 + " " + num2);
    }
}
