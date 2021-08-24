package wexa.saima.meituan;

import java.util.*;

/**
 * description:
 * 小美最近在课外书上发现一篇文章，文章中描述了一种奇怪的序列，名字叫做"阔浩"序列。
 * "阔浩"序列是这样定义的：空串是合法的"阔浩"序列，且它拥有1的代价。
 * 如果s是合法的"阔浩"序列，那么(s)也是合法的"阔浩"序列，且(s)的代价为s的代价加一
 * 如果s，t都是合法的"阔浩"序列，那么它们拼接起来的st也是合法的"阔浩"序列，且总的代价为s的代价乘以t的代价。
 *
 * 例如，(()())() 是合法的"阔浩"序列，而 )(())(() 不是合法的"阔浩"序列，且前者的代价为(2*2+1)*2=10
 * 一行仅包含“ ( ”   和  “ ) ”  的合法"阔浩"序列。（不含引号）
 * 100%的数据保证，"阔浩"序列长度len满足1 <= len <= 200,000。
 * 输出一个数，"阔浩"序列的代价。由于答案可能过大，所以输出模意义下的"阔浩"序列的代价。
 * 形式化的，设代价为ans，输出ans%P（P=1,000,000,007）。其中，%为模运算，用于求解余数，例如5%2=1，9%7=2。
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int n = in.nextInt();
            int[] opts = new int[n];
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                opts[i] = in.nextInt();
                strs[i] = in.next();
            }
            fun(s, opts, strs, n);
        }
    }

    private static void fun(String s, int[] opts, String[] strs, int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - 'a';
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(i);
            map.put(key, list);
        }
        for (int i = 0; i < n; i++) {
            if (opts[i] == 1) {
                char c = strs[i].charAt(0);
                s += c;
                int key = c - 'a';
                List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                list.add(s.length() - 1);
                map.put(key, list);
            } else {
                int index = Integer.parseInt(strs[i]);
                char c = s.charAt(index - 1);
                int key = c - 'a';
                List<Integer> list = map.getOrDefault(key, new ArrayList<>());
                if (list.size() == 0) {
                    System.out.println(-1);
                } else {
                    int min = Integer.MAX_VALUE;
                    for (Integer e : list) {
                        if (e != index - 1)
                            min = Math.min(min, Math.abs(e - index + 1));
                    }
                    min = min == Integer.MAX_VALUE ? -1 : min;
                    System.out.println(min);
                }
            }
        }
    }

}
