package wangyi.solution04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/4/18
 **/
public class Solution {
    private int[][] adjust;
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 检查输入的国家是否在同一大陆
     * @param num int整型 国家数量
     * @param country int整型二维数组 相连国家
     * @param check int整型二维数组 待判断国家
     * @return bool布尔型一维数组
     */
    public boolean[] mainlandCheck (int num, int[][] country, int[][] check) {
        // write code here
        adjust = new int[num][num];
        for (int i = 0;i < country.length; i++) {
            int row = country[i][0];
            int col = country[i][1];
            adjust[row][col] = 1;
            adjust[col][row] = 1;
        }
        process(adjust, num);
        boolean[] res = new boolean[check.length];
        for (int i = 0; i < check.length; i++) {
            int row = check[i][0];
            int col = check[i][1];
            if (row > col) {
                int temp = row;
                row = col;
                col = temp;
            }
            res[i] = adjust[row][col] != 0;
        }
        return res;
    }

    private void process(int[][] adjust, int num) {
        for (int i = 0; i < num; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                if (adjust[i][j] != 0) list.add(j);
            }
            if (!list.isEmpty()) {
                for (int k = 0; k <list.size() - 1; k++) {
                    int row = list.get(k);
                    for (int m = k + 1; m < list.size(); m++) {
                        adjust[row][list.get(m)] = 1;
                        adjust[list.get(m)][row] = 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 9,[[1, 4], [2,3], [3, 5], [6, 7], [2, 4], [8, 0]],[[1, 5], [2, 6], [1, 8]]
        Solution solution = new Solution();
        int num = 9;
        int[][] country = {
                {1, 4}, {2, 3}, {3, 5}, {6, 7}, {2, 4}, {8, 0}
        };
        int[][] check = {
                {1, 5}, {2, 6}, {1, 8}
        };
        boolean[] res = solution.mainlandCheck(num, country, check);
        System.out.println(Arrays.toString(res));
    }

}
