package lc;

/**
 *
 * 给定整数n,找出1...n个整数,不同二叉搜索树的个数
 * G(n):表示1...n个整数,不同二叉搜索树的个数
 * f(i): 表示以i为根节点,1, 2, ... i-1,  共(i - 1)个数为左节点, i+1, i+2, ..., n, 共(n - i)个树为右节点个可能性
 * G(n) = f(1) + f(2) + ... + f(n)
 * f(i) = G(i-1) * G(n-i)
 * tips: 为什么可以用G(n-i)表示右子树的可能行? 可以看作把右子树的每个值减去了i, 表示1, 2, ..., n-i个树的二叉搜索树的可能性
 * @author hawdies
 * @Date 2021/3/23
 **/
public class N96UniqueBinarySearchTree {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] +=dp[j - 1]*dp[i - j];
            }
        }
        return dp[n];
    }
}
