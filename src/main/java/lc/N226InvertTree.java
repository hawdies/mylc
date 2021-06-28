package lc;

/**
 * 反转二叉树
 *
 * @author hawdies
 * @Date 2021/3/29
 **/
public class N226InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
