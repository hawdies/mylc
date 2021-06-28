package lc;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯算法求解全排列问题
 *
 * @author hawdies
 * @Date 2021/2/20
 **/
public class N046Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutes = new N046Permutations().permute(nums);
        System.out.println(permutes);
        for (List<Integer> permute : permutes) {
            System.out.println(permute);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        if (nums.length == 0) return res;

        dfs(list, visited, res, 0, nums.length, nums);

        return res;
    }

    /**
     * @param list    存放一个正确的姐
     * @param visited 标记元素是否已经被使用
     * @param res     最后返回的结果
     * @param index   当前需要填入数据的位置
     * @param end     判断是否填充完毕的边界条件
     * @param nums    需要进行全排列的数组
     */
    public void dfs(List<Integer> list, boolean[] visited, List<List<Integer>> res, int index, int end, int[] nums) {
        if (index == end) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < end; i++) {
            if (visited[i] == false) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(list, visited, res, index + 1, end, nums);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
