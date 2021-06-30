package lc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 来自:剑指offer37题,或leetcod297
 * description: 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 用例:
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 思路: 使用包含NIL的层序遍历.
 * 序列化是使用queue,遇到null也需要入队.
 * 反序列化是也需要使用queue,先将头节点入队,遇到null则不入队.
 *
 * @author hawdies
 * @date 2021/6/30
 **/
public class NOffer37SerializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                TreeNode left = node.left;
                TreeNode right = node.right;
                queue.offer(left);
                queue.offer(right);
                sb.append(node.val).append(",");
            } else {
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!strs[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.left);
            }
            i++;
            if (!strs[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}
