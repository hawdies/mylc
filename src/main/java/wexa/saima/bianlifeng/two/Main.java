package wexa.saima.bianlifeng.two;

import java.util.*;

/**
 * @author hawdies
 * @date 2021/4/9
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            String result = fun(input);
            System.out.println(result);
        }
    }

    private static String fun(String input) {
        int m = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '-') m++;
        }
        int[][] list = new int[m][2];
        List<int[]> result = new ArrayList<>();
        String[] strs = input.split(",");
        int k = 0;
        for (String str : strs) {
            String[] nums = str.split("-");
            int[] e = new int[]{new Integer(nums[0]), new Integer(nums[1])};
            list[k++] = e;
        }
        Arrays.sort(list, Comparator.comparingInt(a -> a[0]));

        result.add(list[0]);
        for (int i = 1; i < m; i++) {
            int[] current = result.get(result.size() - 1);
            if (current[1] < list[i][0]) {
                result.add(list[i]);
            } else {
                current[1] = Math.max(current[1], list[i][1]);
            }
        }
        String res = process(result);
        return res;
    }

    private static String process(List<int[]> result) {
        StringBuilder sb = new StringBuilder();
        for (int[] e : result) {
            sb.append(e[0]).append('-').append(e[1]).append(',');
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
