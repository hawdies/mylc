package others;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author hawdies
 * @Date 2021/3/18
 **/
public class solution03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String xm = in.next();
            String xw = in.next();
            String xl = in.next();
            String ans = fun(n, xm, xw, xl);
            System.out.println(ans);
        }
    }

    private static String fun(int n, String xm, String xw, String xl) {
        xm = xm.toLowerCase();
        xw = xw.toLowerCase();
        xl = xl.toLowerCase();
        int length = xm.length();
        n = n % length;
        int[][] array = new int[3][26];
        for (int i = 0; i < length; i++) {
            char a = xm.charAt(i);
            char b = xw.charAt(i);
            char c = xl.charAt(i);
            if (a >= 'a' && a <= 'z') {
                array[0][a - 'a']++;
            }
            if (b >= 'a' && b <= 'z') {
                array[1][b - 'a']++;
            }
            if (c >= 'a' && c <= 'z') {
                array[2][c - 'a']++;
            }
        }
        int maxA = Arrays.stream(array[0]).max().getAsInt();
        int maxB = Arrays.stream(array[1]).max().getAsInt();
        int maxC = Arrays.stream(array[2]).max().getAsInt();
        if (maxA > maxB && maxA > maxC) {
            return "xiaoming";
        }
        if (maxB > maxA && maxB > maxC) {
            return "xiaowang";
        }
        if (maxC > maxA && maxC > maxB) {
            return "xiaoli";
        }
        return "draw";
    }
}
