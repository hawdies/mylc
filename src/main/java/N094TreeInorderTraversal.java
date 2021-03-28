import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 树的遍历
 *
 * @author hawdies
 * @Date 2021/3/23
 **/
public class N094TreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    // 递归解法
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    // 迭代解法
    private List<Integer> inorderIteration(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p == null) {
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            } else {
                stack.push(p);
                p = p.left;
            }
        }

        return list;
    }

}
