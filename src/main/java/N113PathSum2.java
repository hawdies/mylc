import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author hawdies
 * @date 2021/5/6
 **/
public class N113PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> lists = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        TreeNode currNode = root;
        while (currNode != null || !stack.isEmpty()) {
            while (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            }
            if (!stack.isEmpty()) {
                currNode = stack.peek();
                if (currNode.right == null || currNode.right == preNode) {
                    // 判断是否为叶子节点
                    if (currNode.left == null && currNode.right == null) {
                        process(stack, lists, targetSum);
                    }
                    preNode = stack.pop();
                    currNode = null;
                } else {
                    currNode = currNode.right;
                }
            }
        }
        return lists;
    }

    private void process(Stack<TreeNode> stack, List<List<Integer>> lists, int targetSum) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (TreeNode temp : stack) {
            list.add(temp.val);
            sum += temp.val;
        }
        if (sum == targetSum) {
            lists.add(new ArrayList<>(list));
        }
    }
}
