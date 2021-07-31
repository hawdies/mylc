package wexa.newcoder.yuanfudao;

import java.util.Scanner;
import java.util.Stack;

/**
 * description: 箱子个数问题
 *
 * eg: [][[][][]2]3
 * output 16
 * @author hawdies
 * @date 2021/7/31
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            int res = fun(str);
            System.out.println(res);
        }
    }

    private static int fun(String str) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                stack.push(1);
            } else if (str.charAt(i) == ']') {
                if (i + 1 < str.length() && str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9') {
                    int curNum = str.charAt(i + 1) - '0';
                    i++;
                    stack.push(stack.pop() * curNum);
                }
                stack.push(stack.pop() + stack.pop());
            }
        }
        return stack.pop();
    }
}
