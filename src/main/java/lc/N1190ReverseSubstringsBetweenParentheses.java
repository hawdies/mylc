package lc;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author hawdies
 * @date 2021/5/26
 **/
public class N1190ReverseSubstringsBetweenParentheses {
    /**
     * description: 使用双向队列求解
     *
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     *
     * @param s 输入的字符串,只包括小写字母以及'(', ')'
     * @return 返回按括号从内向外的逆转, 输出的字符串中不含括号
     */
    public String reverseParentheses(String s) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.addLast(sb.toString());
                sb.replace(0, sb.length(), "");
            } else if (s.charAt(i) == ')') {
                String tmp = deque.removeLast();
                sb.reverse();
                sb.insert(0, tmp);

            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    /**
     * 方法二:
     * 使用逆向求解,使用一个数组表示两个括号对应的位置.
     * 当遍历到的括号是,找到对应括号的位置,开始反向遍历
     * 直到结尾,此时字符串的访问顺序就是所需结果.
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     */
    public String reverse02(String s) {
        int n = s.length();
        int[] array = new int[n];
        Stack<Integer> stack = new Stack<>();
        // 初始化对应括号的位置
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int index = stack.pop();
                array[index] = i;
                array[i] = index;
            }
        }

        StringBuilder sb = new StringBuilder();
        int step = 1;
        int index = 0;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                step = -step;
                index = array[index];
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
