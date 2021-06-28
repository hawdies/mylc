package lc;

import java.util.Arrays;

/**
 * @author hawdies
 * @Date 2021/3/3
 **/
public class N062UniquePaths {
    public static void main(String[] args) {
        N062UniquePaths paths = new N062UniquePaths();
        int res = paths.unquiePaths(3, 7);
        System.out.println(res);
    }

    public int unquiePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

}
