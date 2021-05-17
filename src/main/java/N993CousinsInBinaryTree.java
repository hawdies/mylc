/**
 * @author hawdies
 * @date 2021/5/17
 **/
public class N993CousinsInBinaryTree {

    private TreeNode xParent = null;
    private TreeNode yParent = null;
    private int xDept = 0;
    private int yDept = 0;
    private boolean findX = false;
    private boolean findY = false;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xDept == yDept && xParent != yParent;
    }

    private void dfs(TreeNode root, TreeNode parent, int dept, int x, int y) {
        if (findX && findY) return;
        if (root == null) return;
        if (!findX) {
            if (root.val == x) {
                findX = true;
                xDept = dept;
                xParent = parent;
            } else {
                dfs(root.left, root, dept + 1, x, y);
                dfs(root.right, root, dept + 1, x, y);
            }
        }
        if (!findY) {
            if (root.val == y) {
                findY = true;
                yDept = dept;
                yParent = parent;
            } else {
                dfs(root.left, root, dept + 1, x, y);
                dfs(root.right, root, dept + 1, x, y);
            }
        }
    }
}
