package huawei;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author hawdies
 * @date 2021/9/17
 **/
public class Solution1 {
    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        Solution1 demo = new Solution1();
        int[] fun = demo.fun(arr);
        System.out.println(Arrays.toString(fun));
    }
    // temperatures = [73,74,75,71,69,72,76,73]
    public int[] fun(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, arr[0]));
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty()) {
                Node node = stack.peek();
                if (arr[i] - node.value > 0) {
                    ans[node.index] = i - node.index;
                    stack.pop();
                } else break;
            }
            stack.push(new Node(i, arr[i]));
        }
        return ans;
    }

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
