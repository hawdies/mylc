/**
 * @author hawdies
 * @date 2021/4/15
 **/
public class N109ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head, null);
    }

    private TreeNode dfs(ListNode head, ListNode tail) {
        if (head == tail) return null;
        ListNode mid = getMidNode(head, tail);
        TreeNode root = new TreeNode(mid.val);
        TreeNode left = dfs(head, mid);
        TreeNode right = dfs(mid.next, tail);
        root.left = left;
        root.right = right;
        return root;
    }

    private ListNode getMidNode(ListNode head, ListNode tail) {
        ListNode mid = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            mid = mid.next;
            fast = fast.next.next;
        }
        return mid;
    }
}
