package others;

import java.util.Scanner;

/**
 * @author hawdies
 * @Date 2021/3/18
 **/
public class Solution02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String str = in.next();
            int res = fun(n, str);
            System.out.println(res);
        }
    }

    private static int fun(int n, String str) {
        if (str == null || str.length() == 0) return 0;
//        int min = 0;
//        int[] kv = new int[2];
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == '0') {
//                kv[0]++;
//            } else {
//                kv[1]++;
//            }
//        }
//        min = Math.min(kv[0], kv[1]);
//        return min;
        int i = 0;
        int j = str.length() - 1;
        int left = 0;
        int right = 0;
        while (i < j) {
            while (i < j && str.charAt(i) == '0') {
                i++;
            }
            while (i < j && str.charAt(j) == '1') {
                j++;
            }
            if (i < j) {
                left++;
            }
        }
        return left + right;
    }
}
