package lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * description: 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 思路: 使用回溯求解,由于是全排列,需要使用一个visited[]访问数组标记相应元素是否访问过,对于当前位置选择的元素应该是for (int i = 0, i < n, i++)
 * 然后根据的visited[]数组判断元素的选择
 * @author hawdies
 * @date 2021/6/22
 **/
public class NJZ038ZiFuChuanPaiLie {
    private boolean[] visited;

    public String[] permutation(String s) {
        int n = s.length();
        visited = new boolean[n];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(chars, 0, sb, list);
        return list.toArray(new String[0]);
    }

    private void backtrack(char[] src, int index, StringBuilder sb, List<String> list) {
        if (index == src.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < src.length; i++) {
            /**
             * 如果visited[i - 1] == true说明在index位置之前使用了src[i - 1],因此当前位置index可以使用
             * visited[i - 1] == false说明上一次回溯已经使用了src[i - 1]作为当前的index位置的字符(visted[i - 1] 经过了 true -> false的过程.
             * 上一次回溯的是指的在这个for循环内.e.g.: 当前i = 2,此时src[1] != src[2],故不会continue,而是将src[2]放入当前位置,visited[2]赋值经过true -> false.
             * 然后进入 i = 3,此时src[2] == src[3], 由于visited[2] == fasle说明当前位置已经使用过了src[2];
             * 如果此时visted[2] == true,说明是index之前的位置使用了src[2],此时就不用continue跳过
             */
            if (i > 0 && !visited[i - 1] && src[i - 1] == src[i]) continue;
            if (!visited[i]) {
                sb.append(src[i]);
                visited[i] = true;
                backtrack(src, index + 1, sb, list);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


}
