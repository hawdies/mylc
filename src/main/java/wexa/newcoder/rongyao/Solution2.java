package wexa.newcoder.rongyao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/7
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            str = str.replace(" ", "");
            int n = scanner.nextInt();
            List<String> list = fun(str.split(","), n);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    private static List<String> fun(String[] strs, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strs.length; ) {
            int start = i;
            int end = i;
            int total = strs[start].length();
            while (total <= n) {
                if (end + 1 == strs.length) {
                    end++;
                    break;
                }
                end++;
                total += strs[end].length() + 1;
            }
            String resStr = process(strs, n, start, end);
            list.add(resStr);
            i = end;
        }
        String reStr = list.remove(list.size() - 1);
        reStr = processLast(reStr, n);
        list.add(reStr);
        return list;
    }

    private static String process(String[] strs, int n, int start, int end) {
        int wordSize = end - start;
        StringBuilder sb = new StringBuilder();
        // 只有一个单词的情况
        if (wordSize == 1) {
            sb.append(strs[start]);
            for (int i = 0; i < n - strs[start].length(); i++) {
                sb.append("*");
            }
            return sb.toString();
        }

        int starSize = wordSize - 1;
        int totalStarLength = n;
        for (int i = 0; i < wordSize; i++) {
            totalStarLength -= strs[start + i].length();
        }
        int eachStarLength = totalStarLength / starSize;
        int lastStarLength = totalStarLength % starSize;
        for (int i = 0; i < wordSize - 1; i++) {
            sb.append(strs[start + i]);
            for (int j = 0; j < eachStarLength; j++) {
                sb.append("*");
            }
            if (lastStarLength > 0) {
                sb.append("*");
                lastStarLength--;
            }
        }
        // 处理每行的最后一个单词
        sb.append(strs[end - 1]);
        for (int i = 0; i < lastStarLength; i++) {
            sb.append("*");
        }
        return sb.toString();
    }

    private static String processLast(String reStr, int n) {
        String[] split = reStr.split("\\*");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            if (s.length() > 0) {
                sb.append(s);
                if (sb.length() < n) {
                    sb.append("*");
                }
            }
        }
        int len = n - sb.length();
        for (int i = 0; i < len; i++) {
            sb.append("*");
        }
        return sb.toString();
    }


}
