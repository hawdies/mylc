package lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K。
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * tips: 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 * 思路: 以目标节点对左子节点,右子节点,父节点开始递归查找,找到距离为k的所有节点.
 * 由于树没有指向父节点的指针,需要使用hashmap存储当前的节点的父节点.
 * 以目标节点对左子节点,右子节点,父节点递归过程中可能重复查找,所以用一个变量来存储来源节点.
 *
 * eg:
 * 以5开始遍历, 则会遍历6, 2, 3这三个节点. 当遍历当3时, 又会遍历5, 1节点,此时5节点被重复遍历了,因此需要来存储来源节点,避免重复.
 *                  3
 *                 / \
 *                /   \
 *               5     1
 *              / \
 *             /   \
 *            6     2
 *                 / \
 *                /   \
 *               7     4
 * @author hawdies
 * @date 2021/7/28
 **/
public class N863AllNodesDistanceKInTree {
    private Map<Integer, TreeNode> map = new HashMap<>();
    private int k;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findParent(root);
        List<Integer> list = new ArrayList<>();
        this.k = k;
        dfs(target, null, 0, list);
        return list;
    }

    private void dfs(TreeNode root, TreeNode from, int distance, List<Integer> list) {
        if (root == null) return;
        if (distance == k) {
            list.add(root.val);
            return;
        }
        if (root.left != from) {
            dfs(root.left, root, distance + 1, list);
        }
        if (root.right != from) {
            dfs(root.right, root, distance + 1, list);
        }
        TreeNode parent = map.get(root.val);
        if (parent != from) {
            dfs(parent, root, distance + 1, list);
        }
    }


    private void findParent(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            map.put(root.left.val, root);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
        }
    }
}
