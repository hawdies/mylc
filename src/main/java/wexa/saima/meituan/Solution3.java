package wexa.saima.meituan;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            fun02(s);
        }
    }

    private static void fun(String s) {
        long res = dfs(s, 0, s.length());
        System.out.println((int)res);
    }

    private static long dfs(String s, int k, int n) {
        final int MOD = (int)(1e9 + 7);
        long res = 1;
        int num = 0;
        for (int i = k; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                num += 1;
            } else {
                num -= 1;
            }
            if (num == 0) {
                if (i - k == 1) res = res * 2 % MOD;
                else {
                    res = res * (1 + dfs(s, k + 1, i)) % MOD;
                }
                k = i + 1;
            }
        }
        return res;
    }

    private static void fun02(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(1);
            } else {
                int a = stack.pop();
                int b = stack.pop();
                int c = b * (a + 1);
                stack.push(c);
            }
        }
        int res = stack.pop();
        System.out.println(res);
    }
}
