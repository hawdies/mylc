package lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 树的层序遍历
 *
 * @author hawdies
 * @Date 2021/3/23
 **/
public class N102TreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.add(root);
        int levelCount = 1;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int nextCount = 0;
            while (levelCount > 0) {
                TreeNode p = queue.remove();
                levelCount--;
                list.add(p.val);
                if (p.left != null) {
                    queue.add(p.left);
                    nextCount++;
                }
                if (p.right != null) {
                    queue.add(p.right);
                    nextCount++;
                }
            }
            res.add(list);
            levelCount = nextCount;
        }
        return res;
    }
}
