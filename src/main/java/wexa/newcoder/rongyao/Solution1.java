package wexa.newcoder.rongyao;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/7
 **/
public class Solution1 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int l = scanner.nextInt();
//        while (n != 0 && l != 0) {
//            int res = fun(n, l);
//            System.out.println(res);
//            n = scanner.nextInt();
//            l = scanner.nextInt();
//
//        }
        int a = 65535;
        int b = (int) 1e5;
        System.out.println(fun(a, b));
    }

    private static int fun(int n, int l) {
//        BigInteger num1 = new BigInteger(String.valueOf(n));
//        BigInteger res = new BigInteger("0");
//        BigInteger mod = new BigInteger(String.valueOf(MOD));
//        BigInteger num2 = new BigInteger(String.valueOf(n));
//        for (int i = 1; i <= l; i++) {
//            res = res.add(num2).mod(mod);
//            num2 = num2.multiply(num1);
//        }
//        return res.intValue();
        long res = 0;
        long n1 = n;
        for (int i = 1; i <= l; i++) {
            res = (res + n1) % MOD;
            n1 = n1 * n % MOD;
        }
        return (int) res;

    }
}
