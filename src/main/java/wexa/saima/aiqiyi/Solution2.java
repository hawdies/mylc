package wexa.saima.aiqiyi;

import java.util.*;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            int n = Integer.parseInt(s.substring(2));
            fun(n);
        }
    }

    private static void fun(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] arr = new int[n];
//        Arrays.fill(arr, -1);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        dfs(res, arr, set1, set2, set3, 0, n);
        System.out.println(res);
    }

    private static void dfs(List<List<String>> res, int[] arr, Set<Integer> set1, Set<Integer> set2, Set<Integer> set3, int k, int n) {
        if (k == n) {
            List<String> list = new ArrayList<>();
            char[][] chars = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    chars[i][j] = '.';
                }
            }
            for (int i = 0; i < n; i++) {
                chars[i][arr[i]] = 'Q';
                list.add(new String(chars[i]));
            }
            res.add(list);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (set1.contains(i)) continue;
            int k2 = k + i;
            if (set2.contains(k2)) continue;
            int k3 = k - i;
            if (set3.contains(k3)) continue;
            arr[k] = i;
            set1.add(i);
            set2.add(k2);
            set3.add(k3);
            dfs(res, arr, set1, set2, set3, k + 1, n);
            set1.remove(i);
            set2.remove(k2);
            set3.remove(k3);
        }
    }
}
