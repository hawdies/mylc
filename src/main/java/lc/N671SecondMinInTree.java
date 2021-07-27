package lc;

/**
 * description:
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 *
 * 思路: 中序遍历 + 剪枝. res记录最后结果,初始值为-1. rootValue记录根节点值.
 * 由题可知该树根节点的值最小,根节点值 <= 所有子孙节点值.
 * 因此每次递归先判断当前节点与rootValue的大小关系.只有严格大于,才有可能是res的值.
 * 剪枝: 通过比较res和当前节点值,如果当前节点值大,则不必遍历以当前节点为根的子树(因为子树的值肯定都大于)
 *
 * @author hawdies
 * @date 2021/7/27
 **/
public class N671SecondMinInTree {

    int res = -1;
    int rootValue;

    public int findSecondMinimumValue(TreeNode root) {
        rootValue = root.val;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        // 核心两步代码,通过此法可以确保res的值是大于rootValue的最小值.
        if (res != - 1 && root.val >= res) return;
        if (root.val > rootValue) {
            res = root.val;
        }

        dfs(root.left);
        dfs(root.right);
    }
}
