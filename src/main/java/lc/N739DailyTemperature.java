package lc;

import java.util.LinkedList;

/**
 * 使用单调栈求解,栈中存储下表
 *
 * @author hawdies
 * @date 2021/4/7
 **/
public class N739DailyTemperature {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < T.length; i++) {
            if (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                    res[stack.peek()] = i - stack.pop();
                }
            }
            stack.push(i);
        }
        return res;
    }
}
