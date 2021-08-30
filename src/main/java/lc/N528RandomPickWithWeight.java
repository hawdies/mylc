package lc;

/**
 * description: 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），请写一个函数pickIndex，它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比。
 * 例如，对于 w = [1, 3]，挑选下标 0 的概率为 1 / (1 + 3)= 0.25 （即，25%），而选取下标 1 的概率为 3 / (1 + 3)= 0.75（即，75%）。
 * 也就是说，选取下标 i 的概率为 w[i] / sum(w) 。
 *
 * 思路: 前缀和 + 二分查找
 * @author hawdies
 * @date 2021/8/30
 **/
public class N528RandomPickWithWeight {
    private int[] pre;
    private int total;

    public N528RandomPickWithWeight(int[] w) {
        int n = w.length;
        pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + w[i - 1];
        }
        total = pre[n];
    }

    public int pickIndex() {
        int k = (int)(Math.random() * total + 1);
        return binarySearch(k) - 1;
    }

    private int binarySearch(int k) {
        int low = 1;
        int high = pre.length - 1;
        while (low < high) {
            int mid = (high - low >>> 1) + low;
            if (pre[mid] < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
