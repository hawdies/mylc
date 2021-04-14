/**
 * description: 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先
 *
 * 思路1: 使用栈对树进行后序遍历,遇到p或q节点将当前栈内容复制到链表中,此时链表中存着root节点到p,q的路径,问题转化为求公共链表.
 * tips:栈的后序遍历保存了当前节点到根节点的路径.
 *
 * 思路2: 采用递归的思想.定义三个boolean变量inTree, inLtree, inRtree表示当前节点是否含p或q,同理可知其他两个变量含义.
 * 判定当前节点是p,q的最近公共祖先节点的条件是:
 * 可能1:当前节点是p或q, 那么inLtree和inTree有一个为真即可
 * 可能2:当前节点不是p或q,那么inLtree和inTree两个都为真
 * tips: 这种递归方式保证了只有最近的祖先节点满足要求,其他的祖先节点都不会满足(inTree && (inLtree || inRtree)) || (inLtree && inRtree)为真.
 *
 * @author hawdies
 * @date 2021/3/31
 **/
public class N236LowestCommonAncestorTree {

    private TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = root;
        isContains(root, p, q);
        return ans;
    }

    private boolean isContains(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean inTree = root == q || root == p;
        boolean inLtree = isContains(root.left, p, q);
        boolean inRtree = isContains(root.right, p, q);
        if ((inTree && (inLtree || inRtree)) || (inLtree && inRtree)) {
            ans = root;
        }
        return inTree || inLtree || inRtree;
    }
}
