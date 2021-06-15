import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * description: 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * 思路: 动态规划求解
 * 未优化的空间复杂度为O(n^2)
 * 使用滚动数组优化后的空间复杂度为O(n)
 * tips: 注意滚动数组的优化技巧
 *
 * @author hawdies
 * @date 2021/6/15
 **/
public class N129Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        int[] a = {2};
        int[] b = {3, 4};
        int[] c = {6, 5, 7};
        int[] d = {4, 1, 8, 3};
        triangle.add(Arrays.stream(a).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(b).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(c).boxed().collect(Collectors.toList()));
        triangle.add(Arrays.stream(d).boxed().collect(Collectors.toList()));
        N129Triangle n129Triangle = new N129Triangle();
        int res = n129Triangle.minimumTotal(triangle);
        System.out.println(res);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        final int INFINITE_MAX = Integer.MAX_VALUE / 2;
        int n = triangle.size();
        dp.add(triangle.get(0));
        for (int i = 1; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int len = triangle.get(i).size();
            for (int j = 0; j < len; j++) {
                int sum1 = j - 1 >= 0 ? dp.get(i - 1).get(j - 1) : INFINITE_MAX;
                int sum2 = j < len - 1 ? dp.get(i - 1).get(j) : INFINITE_MAX;
                int min = Math.min(sum1, sum2) + triangle.get(i).get(j);
                list.add(min);
            }
            dp.add(list);
        }
        int res = INFINITE_MAX;
        for (int e : dp.get(dp.size() - 1)) {
            res = Math.min(res, e);
        }
        return res;
    }

    // 使用滚动数组优化
    public int minimumTotal2(List<List<Integer>> triangle) {
        final int INFINITE_MAX = Integer.MAX_VALUE / 2;
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int pre = j - 1 >= 0 ? dp[(i - 1) & 1][j - 1] : INFINITE_MAX;
                int cur = j < triangle.get(i).size() - 1 ? dp[(i - 1) & 1][j] : INFINITE_MAX;
                dp[i & 1][j] = Math.min(pre, cur) + triangle.get(i).get(j);
            }

        }
        int res = INFINITE_MAX;
        for (int e : dp[(n - 1) & 1]) {
            res = Math.min(res, e);
        }
        return res;
    }
}
