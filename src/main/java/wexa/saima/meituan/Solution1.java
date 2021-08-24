package wexa.saima.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author hawdies
 * @date 2021/8/22
 **/
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            fun(arr, n);
        }
    }

    private static void fun(int[] arr, int n) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        dfs(arr, res, list, visited, 0, n);
        System.out.println(res.size());
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int[] arr, List<List<Integer>> res, List<Integer> list, boolean[] visited, int k, int n) {
        if (k == n) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1]) continue;
                list.add(arr[i]);
                visited[i] = true;
                dfs(arr, res, list, visited, k + 1, n);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
