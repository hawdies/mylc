package wexa.saima.shunfeng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author hawdies
 * @date 2021/9/6
 **/
public class Solution1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()) {
//            int n = in.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < n; i++) {
//                arr[i] = in.nextInt();
//            }
//            fun(arr, n);
//        }
        int[] arr = {1, 11, 111, 11111, 11111};
        fun(arr, arr.length);
    }

    private static void fun(int[] arr, int n) {
        int[] bases = {11, 111, 111_1, 111_11, 111_111, 111_111_1, 111_111_11, 111_111_111, 111_111_111_1};
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 10 && isOne(arr[i], bases)) {
                count++;
                set.add(arr[i]);
            }
        }
        System.out.println(set.size());
    }

    private static boolean isOne(int k, int[] bases) {

        while (k >= 10) {
            int digit = k;
            int index = -1;
            while (digit >= 10) {
                digit = digit / 10;
                index++;
            }
            if (index == -1) return false;
            k = k - digit * bases[index];
        }
        return k == 0;
    }
}
