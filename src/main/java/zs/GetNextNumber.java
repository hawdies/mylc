package zs;

import java.util.Arrays;

/**
 * desription:
 * 给定int[]数组,返回int[]数组组成的下一个树
 * eg. [5, 5, 6, 4, 3, 7, 3, 2, 1] -> 下一个整数是556471233
 *
 * 思路: 从后往前遍历,找到第一个arr[i] < arr[i + 1]的数,然后进行处理.
 * @author hawdies
 * @date 2021/8/17
 **/
public class GetNextNumber {
    public static void main(String[] args) {
//        int[] arr = {5, 5, 6, 4, 3, 7, 3, 2, 1};
        int[] arr = {3, 2, 1};
        GetNextNumber demo = new GetNextNumber();
        int next = demo.getNext(arr);
        System.out.println(next);
    }

    public int getNext(int[] arr) {
        int n = arr.length;
        int index = n;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                index = i - 1;
                break;
            }
        }
        // 没有下一个最大的数
        if (index == n) {
            int res = 0;
            for (int j : arr) {
                res = res * 10 + j;
            }
            return res;
        }
        // 有下一个的最大数
        int nextNum = Integer.MAX_VALUE;
        int index2 = index;
        for (int i = index + 1; i < n; i++) {
            if (arr[i] > arr[index] && arr[i] < nextNum) {
                nextNum = arr[i];
                index2 = i;
            }
        }
        int tmp = arr[index];
        arr[index] = arr[index2];
        arr[index2] = tmp;
        Arrays.sort(arr, index + 1, n);
        int res = 0;
        for (int j : arr) {
            res = res * 10 + j;
        }
        return res;
    }

}
