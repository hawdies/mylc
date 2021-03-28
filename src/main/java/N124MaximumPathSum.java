/**
 * hard
 *
 * @author hawdies
 * @Date 2021/3/23
 **/
public class N124MaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        // 重点是currentGain和maxSum的不同,当前节点的最大贡献只能是当前节点值+左右子树的最大值(路径不可能即访问左子树又访问右子树)
        // maxSum的值是去当前节点值+左子树节点值+右子树节点值(重点理解)
        int currentGain = root.val + Math.max(left, right);
        maxSum = Math.max(maxSum, root.val + left + right);
        return currentGain;
    }
}
