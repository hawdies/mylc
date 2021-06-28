package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hawdies
 * @Date 2021/3/17
 **/
public class N077Combine {
    public static void main(String[] args) {
        new N077Combine().combine(4, 2);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(1, n, k, list, res);
        return res;
    }

    private void backtrack(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // (n - k + 1 + list.size())
        for (int i = start; i <= n; i++) {
            list.add(i);
            System.out.println("递归前---> " + list);
            backtrack(i + 1, n, k, list, res);
            System.out.println("递归后---> " + list);
            list.remove(list.size() - 1);
        }
    }
}
