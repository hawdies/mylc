import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author hawdies
 * @date 2021/5/7
 **/
public class N103ZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) return lists;
        queue.add(root);
        int levelCount = 1;
        int level = 1;
        while (!queue.isEmpty()) {
            int nextCount = 0;
            List<Integer> list = new ArrayList<>();
            while (levelCount > 0) {
                TreeNode temp = queue.remove();
                levelCount--;
                list.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                    nextCount++;
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                    nextCount++;
                }
            }
            if (level % 2 == 0) Collections.reverse(list);
            level++;
            levelCount = nextCount;
            lists.add(list);
        }
        return lists;
    }
}
