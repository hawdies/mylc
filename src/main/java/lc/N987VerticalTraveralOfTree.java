package lc;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * description:给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * 返回二叉树的 垂序遍历 序列。
 * <p>
 * 思路: 首先中序遍历树,然后记录(row, col, treeNode)到list中,使用优先队列进行排序,按顺序出队即可.
 *
 * @author hawdies
 * @date 2021/7/31
 **/
public class N987VerticalTraveralOfTree {
    static class Node {
        int row;
        int col;
        TreeNode treeNode;

        Node(int row, int col, TreeNode treeNode) {
            this.row = row;
            this.col = col;
            this.treeNode = treeNode;
        }
    }

    public static void main(String[] args) {
        N987VerticalTraveralOfTree demo = new N987VerticalTraveralOfTree();
        String[] arr = {"3", "1", "4", "0", "2", "2"};
        TreeNode root = BuildTreeUtil.buildTree(arr);
        List<List<Integer>> list = demo.verticalTraversal(root);
        System.out.println(list);
    }

    private List<Node> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        PriorityQueue<Node> queue = new PriorityQueue<>((node1, node2) -> {
            if (node1.row == node2.row && node1.col == node2.col) {
                return node1.treeNode.val - node2.treeNode.val;
            } else if (node1.col == node2.col) {
                return node1.row - node2.row;
            } else {
                return node1.col - node2.col;
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        queue.addAll(list);
        int col = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (col != poll.col) {
                col = poll.col;
                List<Integer> resList = new ArrayList<>();
                resList.add(poll.treeNode.val);
                while (!queue.isEmpty()) {
                    Node node = queue.peek();
                    if (node.col == col) {
                        resList.add(node.treeNode.val);
                        queue.poll();
                    } else {
                        break;
                    }
                }
                res.add(resList);
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;
        Node node = new Node(row, col, root);
        list.add(node);
        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }

}
